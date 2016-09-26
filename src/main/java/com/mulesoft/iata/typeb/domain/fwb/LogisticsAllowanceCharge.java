package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class LogisticsAllowanceCharge {
    private String id;
    private String prepaidIndicator;
    private String partyTypeCode;
    private String actualAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrepaidIndicator() {
        return prepaidIndicator;
    }

    public void setPrepaidIndicator(String prepaidIndicator) {
        this.prepaidIndicator = prepaidIndicator;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }
}
