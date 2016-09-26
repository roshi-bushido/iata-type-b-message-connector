package com.mulesoft.iata.typeb.domain.fwb;

/**
 * Created by msuarez on 9/14/16.
 */
public class Waybill {
    private BusinessHeaderDocument businessHeaderDocument;
    private MasterConsignment masterConsignment = new MasterConsignment();

    public BusinessHeaderDocument getBusinessHeaderDocument() {
        return businessHeaderDocument;
    }

    public void setBusinessHeaderDocument(BusinessHeaderDocument businessHeaderDocument) {
        this.businessHeaderDocument = businessHeaderDocument;
    }

    public MasterConsignment getMasterConsignment() {
        return masterConsignment;
    }

    public void setMasterConsignment(MasterConsignment masterConsignment) {
        this.masterConsignment = masterConsignment;
    }
}
