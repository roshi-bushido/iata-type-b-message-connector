package com.mulesoft.iata.typeb.domain.fhl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msuarez on 9/13/16.
 */
public class Consignment {
    private String grossWeightMeasureUnit;
    private String grossWeightMeasureValue;
    private String totalPieceQuantity;
    private String transportContractDocumentId;
    private String originLocation;
    private String finalDestinationLocation;
    private List<HouseConsignment> houseConsignments = new ArrayList<>();

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

    public String getTotalPieceQuantity() {
        return totalPieceQuantity;
    }

    public void setTotalPieceQuantity(String totalPieceQuantity) {
        this.totalPieceQuantity = totalPieceQuantity;
    }

    public String getTransportContractDocumentId() {
        return transportContractDocumentId;
    }

    public void setTransportContractDocumentId(String transportContractDocumentId) {
        this.transportContractDocumentId = transportContractDocumentId;
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

    public List<HouseConsignment> getHouseConsignments() {
        return houseConsignments;
    }

    public void setHouseConsignments(List<HouseConsignment> houseConsignments) {
        this.houseConsignments = houseConsignments;
    }
}
