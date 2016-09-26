package com.mulesoft.iata.typeb.domain.fwb;

import com.mulesoft.iata.typeb.domain.fwb.party.Party;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msuarez on 9/14/16.
 */
public class MasterConsignment {
    private Party shipper;
    private Party consignee;
    private FreightForwarderParty freightForwarderParty;
    private String originLocation;
    private String finalDestinationLocation;
    private String grossWeightMeasureUnit;
    private String grossWeightMeasureValue;
    private String totalPieceQuantity;
    private Instructions handlingSSRInstructions;
    private Instructions handlingOSIInstructions;
    private String applicableOriginCurrencyExchangeCode;
    private String applicableLogisticsServiceChargeCode;
    private List<LogisticsTransportMovement> transportMovementList = new ArrayList<>();
    private List<LogisticsAllowanceCharge> applicableLogisticsAllowanceCharges = new ArrayList<>();
    private ApplicableRating applicableRating;
    private ApplicableTotalRating applicableTotalRating;

    public ApplicableTotalRating getApplicableTotalRating() {
        return applicableTotalRating;
    }

    public void setApplicableTotalRating(ApplicableTotalRating applicableTotalRating) {
        this.applicableTotalRating = applicableTotalRating;
    }

    public ApplicableRating getApplicableRating() {
        return applicableRating;
    }

    public void setApplicableRating(ApplicableRating applicableRating) {
        this.applicableRating = applicableRating;
    }

    public List<LogisticsAllowanceCharge> getApplicableLogisticsAllowanceCharges() {
        return applicableLogisticsAllowanceCharges;
    }

    public void setApplicableLogisticsAllowanceCharges(List<LogisticsAllowanceCharge> applicableLogisticsAllowanceCharges) {
        this.applicableLogisticsAllowanceCharges = applicableLogisticsAllowanceCharges;
    }

    public String getApplicableOriginCurrencyExchangeCode() {
        return applicableOriginCurrencyExchangeCode;
    }

    public void setApplicableOriginCurrencyExchangeCode(String applicableOriginCurrencyExchangeCode) {
        this.applicableOriginCurrencyExchangeCode = applicableOriginCurrencyExchangeCode;
    }

    public String getApplicableLogisticsServiceChargeCode() {
        return applicableLogisticsServiceChargeCode;
    }

    public void setApplicableLogisticsServiceChargeCode(String applicableLogisticsServiceChargeCode) {
        this.applicableLogisticsServiceChargeCode = applicableLogisticsServiceChargeCode;
    }

    public Instructions getHandlingSSRInstructions() {
        return handlingSSRInstructions;
    }

    public void setHandlingSSRInstructions(Instructions handlingSSRInstructions) {
        this.handlingSSRInstructions = handlingSSRInstructions;
    }

    public Instructions getHandlingOSIInstructions() {
        return handlingOSIInstructions;
    }

    public void setHandlingOSIInstructions(Instructions handlingOSIInstructions) {
        this.handlingOSIInstructions = handlingOSIInstructions;
    }

    public List<LogisticsTransportMovement> getTransportMovementList() {
        return transportMovementList;
    }

    public void setTransportMovementList(List<LogisticsTransportMovement> transportMovementList) {
        this.transportMovementList = transportMovementList;
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

    public Party getShipper() {
        return shipper;
    }

    public void setShipper(Party shipper) {
        this.shipper = shipper;
    }

    public Party getConsignee() {
        return consignee;
    }

    public void setConsignee(Party consignee) {
        this.consignee = consignee;
    }

    public FreightForwarderParty getFreightForwarderParty() {
        return freightForwarderParty;
    }

    public void setFreightForwarderParty(FreightForwarderParty freightForwarderParty) {
        this.freightForwarderParty = freightForwarderParty;
    }
}
