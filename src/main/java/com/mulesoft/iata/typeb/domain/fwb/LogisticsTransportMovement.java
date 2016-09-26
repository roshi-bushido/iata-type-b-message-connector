package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class LogisticsTransportMovement {
    private String stageCode = "Main-Carriage";
    private OccurrenceArrivalLocation arrivalEvent;

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public OccurrenceArrivalLocation getArrivalEvent() {
        return arrivalEvent;
    }

    public void setArrivalEvent(OccurrenceArrivalLocation arrivalEvent) {
        this.arrivalEvent = arrivalEvent;
    }
}
