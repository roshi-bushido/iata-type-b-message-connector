package com.mulesoft.iata.typeb.domain;

import com.mulesoft.iata.typeb.domain.fhl.Consignment;
import com.mulesoft.iata.typeb.domain.fwb.Waybill;

/**
 * Created by msuarez on 9/13/16.
 */
public class TypeBMessage {
    private Destination destination;
    private Origin origin;
    private String type;
    private Consignment consignment;
    private Waybill waybill;

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Consignment getConsignment() {
        return consignment;
    }

    public void setConsignment(Consignment consignment) {
        this.consignment = consignment;
    }
}
