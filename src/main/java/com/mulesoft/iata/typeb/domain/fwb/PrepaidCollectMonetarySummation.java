package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class PrepaidCollectMonetarySummation {
    private String prepaidIndicator;
    private String weightChargeTotalAmount;
    private String carrierTotalDuePayableAmount;
    private String grandTotalAmount;

    public String getPrepaidIndicator() {
        return prepaidIndicator;
    }

    public void setPrepaidIndicator(String prepaidIndicator) {
        this.prepaidIndicator = prepaidIndicator;
    }

    public String getWeightChargeTotalAmount() {
        return weightChargeTotalAmount;
    }

    public void setWeightChargeTotalAmount(String weightChargeTotalAmount) {
        this.weightChargeTotalAmount = weightChargeTotalAmount;
    }

    public String getCarrierTotalDuePayableAmount() {
        return carrierTotalDuePayableAmount;
    }

    public void setCarrierTotalDuePayableAmount(String carrierTotalDuePayableAmount) {
        this.carrierTotalDuePayableAmount = carrierTotalDuePayableAmount;
    }

    public String getGrandTotalAmount() {
        return grandTotalAmount;
    }

    public void setGrandTotalAmount(String grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }
}
