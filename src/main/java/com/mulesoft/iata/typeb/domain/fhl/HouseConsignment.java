package com.mulesoft.iata.typeb.domain.fhl;

/**
 * Created by msuarez on 9/13/16.
 */
public class HouseConsignment {
    private String sequence;
    private String grossWeightMeasureUnit;
    private String grossWeightMeasureValue;
    private String pieceQuantity;
    private String description;
    private String transportContractDocument;
    private String originLocation;
    private String finalDestinationLocation;
    private CustomNote customNote = new CustomNote();

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getGrossWeightMeasureUnit() {
        return grossWeightMeasureUnit;
    }

    public void setGrossWeightMeasureUnit(String grossWeightMeasureUnit) {
        this.grossWeightMeasureUnit = grossWeightMeasureUnit;
    }

    public String getGrossWeightMeasureValue() {
        return grossWeightMeasureValue;
    }

    public void setGrossWeightMeasureValue(String grossWeightMeasureValue) {
        this.grossWeightMeasureValue = grossWeightMeasureValue;
    }

    public String getPieceQuantity() {
        return pieceQuantity;
    }

    public void setPieceQuantity(String pieceQuantity) {
        this.pieceQuantity = pieceQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransportContractDocument() {
        return transportContractDocument;
    }

    public void setTransportContractDocument(String transportContractDocument) {
        this.transportContractDocument = transportContractDocument;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getFinalDestinationLocation() {
        return finalDestinationLocation;
    }

    public void setFinalDestinationLocation(String finalDestinationLocation) {
        this.finalDestinationLocation = finalDestinationLocation;
    }

    public CustomNote getCustomNote() {
        return customNote;
    }

    public void setCustomNote(CustomNote customNote) {
        this.customNote = customNote;
    }
}
