package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class ApplicableTotalRating {
    private String typeCode;
    private PrepaidCollectMonetarySummation applicablePrepaidCollectMonetarySummation;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public PrepaidCollectMonetarySummation getApplicablePrepaidCollectMonetarySummation() {
        return applicablePrepaidCollectMonetarySummation;
    }

    public void setApplicablePrepaidCollectMonetarySummation(PrepaidCollectMonetarySummation applicablePrepaidCollectMonetarySummation) {
        this.applicablePrepaidCollectMonetarySummation = applicablePrepaidCollectMonetarySummation;
    }
}
