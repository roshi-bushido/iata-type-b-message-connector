package com.mulesoft.iata.typeb.domain.fwb;

import com.mulesoft.iata.typeb.domain.fwb.header.SignatoryCarrierAuthentication;
import com.mulesoft.iata.typeb.domain.fwb.header.SignatoryShipperAuthentication;

/**
 * Created by msuarez on 9/14/16.
 */
public class BusinessHeaderDocument {
    private String id;
    private SignatoryShipperAuthentication signatoryShipperAuthentication;
    private SignatoryCarrierAuthentication signatoryCarrierAuthentication;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SignatoryShipperAuthentication getSignatoryShipperAuthentication() {
        return signatoryShipperAuthentication;
    }

    public void setSignatoryShipperAuthentication(SignatoryShipperAuthentication signatoryShipperAuthentication) {
        this.signatoryShipperAuthentication = signatoryShipperAuthentication;
    }

    public SignatoryCarrierAuthentication getSignatoryCarrierAuthentication() {
        return signatoryCarrierAuthentication;
    }

    public void setSignatoryCarrierAuthentication(SignatoryCarrierAuthentication signatoryCarrierAuthentication) {
        this.signatoryCarrierAuthentication = signatoryCarrierAuthentication;
    }
}
