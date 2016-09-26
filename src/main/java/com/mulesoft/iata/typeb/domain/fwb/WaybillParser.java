package com.mulesoft.iata.typeb.domain.fwb;

import com.mulesoft.iata.typeb.domain.fwb.header.IssueAuthenticationLocation;
import com.mulesoft.iata.typeb.domain.fwb.header.SignatoryCarrierAuthentication;
import com.mulesoft.iata.typeb.domain.fwb.header.SignatoryShipperAuthentication;
import com.mulesoft.iata.typeb.domain.fwb.party.Party;
import com.mulesoft.iata.typeb.domain.fwb.party.PostalAddress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msuarez on 9/13/16.
 */
public class WaybillParser {
    private String separator = "/";
    private List<String> segments;

    public WaybillParser(List<String> segments) {
        this.segments = segments;
    }

    protected Map<String, List<String>> getGroupedSegments() {
        Map<String, List<String>> map = new HashMap<>();

        List<String> sectionSegments = this.segments.subList(1, segments.size());

        String lastSectionName = null;
        List<String> currentSegments = new ArrayList<>();

        for(int i=0; i < sectionSegments.size(); i++) {
            String segment = sectionSegments.get(i);
            if (!segment.startsWith("/")) {
                String currentSectionName = segment.substring(0, 3);
                if (lastSectionName == null) {
                    lastSectionName = currentSectionName;
                } else {
                    map.put(lastSectionName, currentSegments);
                    lastSectionName = currentSectionName;
                    currentSegments = new ArrayList<>();
                }
            }
            currentSegments.add(segment);


            // we check for the last element
            if (i == sectionSegments.size() -1) {
                map.put(lastSectionName, currentSegments);
            }
        }

        return map;
    }

    public Waybill getWaybill() {
        Map<String, List<String>> segmentMap = this.getGroupedSegments();

        String[] locationSegments = this.segments.get(0).split(separator);
        String[] movementSegments = segmentMap.get("RTG").get(0).split(separator);
        String[] packageInfo = locationSegments[1].replace("T", "").split("K");

        Waybill bill = new Waybill();
        bill.setBusinessHeaderDocument(parserBusinessHeader(segmentMap));
        bill.getMasterConsignment().setShipper(parseParty(segmentMap.get("SHP").subList(1, segmentMap.get("SHP").size())));
        bill.getMasterConsignment().setConsignee(parseParty(segmentMap.get("CNE").subList(1, segmentMap.get("CNE").size())));
        bill.getMasterConsignment().setFreightForwarderParty(parseFreightForwarderParty(segmentMap));
        bill.getMasterConsignment().setOriginLocation(locationSegments[0].substring(12, 15));
        bill.getMasterConsignment().setFinalDestinationLocation(locationSegments[0].substring(15, 18));
        bill.getMasterConsignment().setGrossWeightMeasureUnit("K");
        bill.getMasterConsignment().setGrossWeightMeasureValue(packageInfo[1]);
        bill.getMasterConsignment().setTotalPieceQuantity(packageInfo[0]);
        bill.getMasterConsignment().getTransportMovementList().add(parseMovement(movementSegments[1]));
        bill.getMasterConsignment().getTransportMovementList().add(parseMovement(movementSegments[2]));
        bill.getMasterConsignment().setApplicableOriginCurrencyExchangeCode(segmentMap.get("CVD").get(0).split(separator)[1]);
        bill.getMasterConsignment().setApplicableLogisticsServiceChargeCode(segmentMap.get("CVD").get(0).split(separator)[2]);

        if (segmentMap.containsKey("OTH")) {
            List<String> lines = segmentMap.get("OTH");
            for (String line: lines) {
                bill.getMasterConsignment().getApplicableLogisticsAllowanceCharges().add(parseAllowanceCharge(line.replace("OTH", "")));
            }
        }

        if (segmentMap.containsKey("SSR")) {
            bill.getMasterConsignment().setHandlingOSIInstructions(parseInstructions(segmentMap.get("SSR").get(0)));
        }
        if (segmentMap.containsKey("OSI")) {
            bill.getMasterConsignment().setHandlingSSRInstructions(parseInstructions(segmentMap.get("OSI").get(0)));
        }

        bill.getMasterConsignment().setApplicableRating(parseApplicableRating(segmentMap.get("RTD")));
        bill.getMasterConsignment().setApplicableTotalRating(parseApplicableTotalRating(segmentMap.get("PPD")));
        return bill;
    }

    protected FreightForwarderParty parseFreightForwarderParty(Map<String, List<String>> segmentMap) {
        List<String> segments = segmentMap.get("AGT");
        String[] idSegments = segments.get(0).split(separator);

        PostalAddress address = new PostalAddress();
        address.setCityName(segments.get(2).split(separator)[1]);

        FreightForwarderParty party = new FreightForwarderParty();
        party.setFreightForwarderAddress(address);
        party.setName(segments.get(1).split(separator)[1]);
        party.setAccountID(idSegments[1]);
        party.setCargoAgentID(idSegments[2]);
        party.setSpecifiedCargoAgentLocationId(idSegments[3]);
        return party;
    }

    private ApplicableTotalRating parseApplicableTotalRating(List<String> segments) {
        List<String> mainRating = segments.subList(0,2);
        String[] mainLine1 =  mainRating.get(0).replace("PPD", "").split(separator);
        String[] mainLine2 =  mainRating.get(1).split(separator);

        PrepaidCollectMonetarySummation summary = new PrepaidCollectMonetarySummation();
        summary.setPrepaidIndicator("true");
        summary.setWeightChargeTotalAmount(mainLine1[1].replace("WT", ""));
        summary.setCarrierTotalDuePayableAmount(mainLine2[1].replace("OC", ""));
        summary.setGrandTotalAmount(mainLine2[2].replace("CT", ""));

        ApplicableTotalRating rating = new ApplicableTotalRating();
        rating.setTypeCode("F");
        rating.setApplicablePrepaidCollectMonetarySummation(summary);
        return rating;
    }

    private ApplicableRating parseApplicableRating(List<String> segments) {
        List<String> mainRating = segments.subList(0,2);
        String[] mainLine1 =  mainRating.get(0).replace("RTD", "").split(separator);
        String[] mainLine2 =  mainRating.get(1).split(separator);

        FreightRateServiceCharge charge = new FreightRateServiceCharge();
        charge.setCategoryCode("N");
        charge.setChargeableWeightMeasure(mainLine1[5].replace("W", ""));
        charge.setAppliedRate(mainLine1[6].replace("R", ""));
        charge.setAppliedAmount(mainLine1[7].replace("T", ""));

        ConsignmentItem mainItem = new ConsignmentItem();
        mainItem.setSequence("1");
        mainItem.setPieceQuantity(mainLine1[2].replace("P", ""));
        mainItem.setGrossWeightMeasureUnit("KG");
        mainItem.setGrossWeightMeasureValue(mainLine1[3].replace("K", ""));
        mainItem.setNatureTransportCargoID(mainLine2[2]);
        mainItem.setFreightRateServiceCharge(charge);

        ApplicableRating rating = new ApplicableRating();
        rating.setTypeCode("F");
        rating.getItems().add(mainItem);

        List<String> secondaryRatingLines = segments.subList(2,segments.size());
        for (String line: secondaryRatingLines) {
            rating.getItems().add(parseApplicationRatingSecondaryItem(line));
        }

        return rating;
    }

    private ConsignmentItem parseApplicationRatingSecondaryItem(String segment) {
        String[] segments = segment.split(separator);
        String type = segments[2];

        ConsignmentItem item = new ConsignmentItem();
        item.setSequence(segments[1]);

        if ("NC".equalsIgnoreCase(type)) {
            item.setNatureTransportCargoID(segments[3]);
        }

        if ("ND".equalsIgnoreCase(type)) {
            item.setInformation(segments[4]);
        }

        if ("NS".equalsIgnoreCase(type)) {
            item.setPackageQuantity(segments[3]);
        }
        if ("NO".equalsIgnoreCase(type)) {
            item.setOriginCountryID(segments[3]);
        }

        return item;
    }

    private LogisticsAllowanceCharge parseAllowanceCharge(String segment) {
        String[] segments = segment.split(separator);
        String chargeSegment = segments[2];

        LogisticsAllowanceCharge charge = new LogisticsAllowanceCharge();
        charge.setId(chargeSegment.substring(0,2));
        charge.setPartyTypeCode(chargeSegment.substring(2,3));
        charge.setActualAmount(chargeSegment.substring(3, chargeSegment.length()));
        charge.setPrepaidIndicator(Boolean.toString("p".equalsIgnoreCase(segments[1])));
        return charge;
    }

    protected Instructions parseInstructions(String segment) {
        Instructions instructions = new Instructions();
        instructions.setDescription(segment.split(separator)[1]);
        return instructions;
    }

    protected LogisticsTransportMovement parseMovement(String segment) {
        OccurrenceArrivalLocation event = new OccurrenceArrivalLocation();
        event.setId(segment.substring(0, 3));
        event.setName(segment.substring(3, 5));
        LogisticsTransportMovement movement = new LogisticsTransportMovement();
        movement.setArrivalEvent(event);
        return movement;
    }

    protected BusinessHeaderDocument parserBusinessHeader(Map<String, List<String>> segmentMap) {
        String id = this.segments.get(0).split(separator)[0];

        String[] isu = segmentMap.get("ISU").get(0).split(separator);

        IssueAuthenticationLocation location = new IssueAuthenticationLocation();
        location.setName(isu[2]);

        SignatoryCarrierAuthentication carrierAuth = new SignatoryCarrierAuthentication();
        carrierAuth.setIssueAuthenticationLocation(location);
        carrierAuth.setSignatory(isu[3]);
        carrierAuth.setActualDateTime(isu[1]);

        SignatoryShipperAuthentication shipperAuth = new SignatoryShipperAuthentication();

        BusinessHeaderDocument document = new BusinessHeaderDocument();
        document.setId(id.substring(0, 12));
        document.setSignatoryCarrierAuthentication(carrierAuth);
        document.setSignatoryShipperAuthentication(shipperAuth);
        return document;
    }

    protected Party parseParty(List<String> partySegments) {
        String[] location = partySegments.get(3).split(separator);

        PostalAddress address = new PostalAddress();
        address.setStreetName(partySegments.get(1).split(separator)[1]);
        address.setCityName(partySegments.get(2).split(separator)[1]);
        address.setCountryCode(location[1]);

        if (location.length > 2) {
            address.setPostalCode(location[2]);
        }

        Party party = new Party();
        party.setAddress(address);
        party.setName(partySegments.get(0).split(separator)[1]);
        return party;
    }

}
