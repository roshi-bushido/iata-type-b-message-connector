package com.mulesoft.iata.typeb;

import com.mulesoft.iata.typeb.domain.*;
import com.mulesoft.iata.typeb.domain.fhl.Consignment;
import com.mulesoft.iata.typeb.domain.fhl.ConsignmentParser;
import com.mulesoft.iata.typeb.domain.fwb.Waybill;
import com.mulesoft.iata.typeb.domain.fwb.WaybillParser;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by msuarez on 9/13/16.
 */
public class TypeBMessageParser {
    private String content;
    private final String lineSeparator = "__SEP__";
    private List<TypeBMessage> list = new ArrayList<>();
    private List<DiscartedMessage> discardedMessages = new ArrayList<>();

    public static TypeBMessageParser newWithContent(String content) {
        TypeBMessageParser parser = new TypeBMessageParser();
        parser.content = content;
        return parser;
    }

    public static TypeBMessageParser newWithUrl(String url) throws IOException {
        InputStream stream = new FileInputStream(new File(url));
        StringWriter writer = new StringWriter();
        IOUtils.copy(stream, writer);

        TypeBMessageParser parser = new TypeBMessageParser();
        parser.content = writer.toString();
        return parser;
    }

    public TypeBMessageParser parse() {
        String[] lines = this.content.split(System.getProperty("line.separator"));

        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < lines.length; i++) {
            String line = lines[i];

            if ("\r".equalsIgnoreCase(line) || (i == lines.length-1)) {
                try {
                    buffer.append(line + lineSeparator);
                    list.add(this.parseMessage(buffer.toString()));
                    buffer = new StringBuffer();
                } catch (Exception e) {
                    e.printStackTrace();
                    discardedMessages.add(new DiscartedMessage(buffer.toString()));
                }
            } else {
                buffer.append(line + lineSeparator);
            }
        }

        return this;
    }

    public List<TypeBMessage> getMessageList() {
        return this.list;
    }

    public List<DiscartedMessage> getDiscardedMessages() {
        return discardedMessages;
    }

    protected TypeBMessage parseMessage(String singleMessage) {
    	singleMessage = singleMessage.replaceAll("\r", "");
        List<String> lines = Arrays.asList(singleMessage.split(lineSeparator));
        String destination = lines.get(0);
        String origin = lines.get(1);
        String messageType = lines.get(2);
        List<String> messagePayload = lines.subList(3, lines.size());

        TypeBMessage message = new TypeBMessage();
        message.setDestination(parseDestination(destination));
        message.setOrigin(parseOrigin(origin));
        message.setType(messageType);

        if (SupportedMessageTypes.FHL_4.equalsIgnoreCase(messageType)) {
            message.setConsignment(parseConsignment(messagePayload));
        }
        if (SupportedMessageTypes.FWB_16.equalsIgnoreCase(messageType)) {
            message.setWaybill(parseWaybill(messagePayload));
        }
        return message;
    }

    protected Waybill parseWaybill(List<String> segments) {
        WaybillParser parser = new WaybillParser(segments);
        return parser.getWaybill();
    }


    protected Consignment parseConsignment(List<String> segments) {
        ConsignmentParser parser = new ConsignmentParser(segments);
        return parser.getConsignment();
    }

    protected Origin parseOrigin(String originSegment) {
        String addressSegment = originSegment.substring(1, 8);
        String date = originSegment.substring(9, 15);
        Origin origin = new Origin();
        origin.setAddress(parseAddress(addressSegment));
        origin.setDate(date);
        return origin;
    }

    protected Destination parseDestination(String destinationLine) {
        List<String> segments = Arrays.asList(destinationLine.split(" "));
        String priority = segments.get(0);
        Destination destination = new Destination();
        destination.setPriority(priority);

        List<String> addresses = segments.subList(1, segments.size());
        for (String addressSegment: addresses) {
            destination.getAddresses().add(this.parseAddress(addressSegment));
        }
        return destination;
    }

    protected Address parseAddress(String addressSegment) {
        Address address = new Address();
        address.setOrigin(addressSegment.substring(0, 4));
        address.setFunction(addressSegment.substring(3, 5));
        address.setAirline(addressSegment.substring(5, 7));
        return address;
    }
}
