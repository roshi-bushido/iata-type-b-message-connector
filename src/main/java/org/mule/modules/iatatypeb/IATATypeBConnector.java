package org.mule.modules.iatatypeb;

import java.util.List;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.iatatypeb.config.ConnectorConfig;

import com.mulesoft.iata.typeb.TypeBMessageParser;
import com.mulesoft.iata.typeb.domain.TypeBMessage;

@Connector(name="iata-type-b", friendlyName="IATA Type B")
public class IATATypeBConnector {

    @Config
    ConnectorConfig config;

    /**
     * Parses a single message
     *
     * @param the type B message content
     * @return a {@link TypeBMessage} object
     */
    @Processor
    public TypeBMessage parseMessage(String message) {
    	TypeBMessageParser parser = TypeBMessageParser.newWithContent(message);
    	return parser.parse().getMessageList().get(0);
    }

    /**
     * Parses a single message
     *
     * @param the type B message content
     * @return a {@link TypeBMessage} object
     */
    @Processor
    public List<TypeBMessage> parseList(String message) {
    	TypeBMessageParser parser = TypeBMessageParser.newWithContent(message);
    	return parser.parse().getMessageList();
    }
    
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}