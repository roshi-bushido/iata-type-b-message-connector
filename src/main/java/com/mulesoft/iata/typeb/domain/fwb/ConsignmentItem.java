package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class ConsignmentItem {
    private String sequence;
    private String natureTransportCargoID;
    private String information;
    private String packageQuantity;
    private String originCountryID;

    private String grossWeightMeasureUnit;
    private String grossWeightMeasureValue;
    private String pieceQuantity;
    private FreightRateServiceCharge freightRateServiceCharge;

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

    public FreightRateServiceCharge getFreightRateServiceCharge() {
        return freightRateServiceCharge;
    }

    public void setFreightRateServiceCharge(FreightRateServiceCharge freightRateServiceCharge) {
        this.freightRateServiceCharge = freightRateServiceCharge;
    }

    public String getOriginCountryID() {
        return originCountryID;
    }

    public void setOriginCountryID(String originCountryID) {
        this.originCountryID = originCountryID;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getNatureTransportCargoID() {
        return natureTransportCargoID;
    }

    public void setNatureTransportCargoID(String natureTransportCargoID) {
        this.natureTransportCargoID = natureTransportCargoID;
    }
}
