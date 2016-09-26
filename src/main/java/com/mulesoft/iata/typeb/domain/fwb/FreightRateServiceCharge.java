package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class FreightRateServiceCharge {
    private String categoryCode;
    private String chargeableWeightMeasure;
    private String appliedRate;
    private String appliedAmount;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getChargeableWeightMeasure() {
        return chargeableWeightMeasure;
    }

    public void setChargeableWeightMeasure(String chargeableWeightMeasure) {
        this.chargeableWeightMeasure = chargeableWeightMeasure;
    }

    public String getAppliedRate() {
        return appliedRate;
    }

    public void setAppliedRate(String appliedRate) {
        this.appliedRate = appliedRate;
    }

    public String getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(String appliedAmount) {
        this.appliedAmount = appliedAmount;
    }
}
