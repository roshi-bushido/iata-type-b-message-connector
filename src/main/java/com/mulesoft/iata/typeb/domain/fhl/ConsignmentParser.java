package com.mulesoft.iata.typeb.domain.fhl;

import java.util.List;

/**
 * Created by msuarez on 9/13/16.
 */
public class ConsignmentParser {
    private List<String> segments;

    public ConsignmentParser(List<String> segments) {
        this.segments = segments;
    }

    public Consignment getConsignment() {
        Consignment consignment = new Consignment();

        for (String segment: this.segments) {
            if (segment.toUpperCase().startsWith("MBI")) {
                this.enrichWithMBI(consignment, segment);
            }
            if (segment.toUpperCase().startsWith("HBS")) {
                this.enrichWithHBS(consignment, segment);
            }
            if (segment.toUpperCase().startsWith("OCI")) {
                this.enrichWithOCI(consignment, segment);
            }
        }
        return consignment;
    }

    private void enrichWithOCI(Consignment consignment, String segment) {
        String[] segmentParts = segment.split("/");
        String noteType = segmentParts[3];
        String noteContent = segmentParts[4];
        for(HouseConsignment h: consignment.getHouseConsignments()) {
            h.getCustomNote().setType(noteType);
            h.getCustomNote().setContent(noteContent);
        }
    }

    private void enrichWithHBS(Consignment consignment, String segment) {
        String[] segmentParts = segment.split("/");

        HouseConsignment house = new HouseConsignment();

        house.setTransportContractDocument(segmentParts[1]);
        house.setOriginLocation(segmentParts[2].substring(0,3));
        house.setFinalDestinationLocation(segmentParts[2].substring(3,6));
        house.setSequence(segmentParts[3]);
        house.setGrossWeightMeasureUnit(segmentParts[4].substring(0, 1));
        house.setGrossWeightMeasureValue(segmentParts[4].substring(1, segmentParts[4].length()));
        house.setDescription(segmentParts[6]);
        house.setTransportContractDocument(consignment.getTransportContractDocumentId());
        house.setOriginLocation(consignment.getOriginLocation());
        house.setFinalDestinationLocation(consignment.getFinalDestinationLocation());
        consignment.getHouseConsignments().add(house);
    }

    private void enrichWithMBI(Consignment consignment, String segment) {
        String[] segmentParts = segment.split("/");

        String transportDoc = segmentParts[1];
        String item = segmentParts[2];
        String[] items = item.split("K");
        consignment.setGrossWeightMeasureUnit("K");
        consignment.setGrossWeightMeasureValue(items[1]);
        consignment.setTotalPieceQuantity(items[0].substring(1,2));
        consignment.setTransportContractDocumentId(transportDoc.substring(0, 12));
        consignment.setOriginLocation(transportDoc.substring(12, 15));
        consignment.setFinalDestinationLocation(transportDoc.substring(15, transportDoc.length()));
    }
}
