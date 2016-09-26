package com.mulesoft.iata.typeb.domain.fwb;

import com.mulesoft.iata.typeb.domain.fwb.party.PostalAddress;

/**
 * Created by msuarez on 9/14/16.
 */
public class FreightForwarderParty {
    private String name;
    private String accountID;
    private String cargoAgentID;
    private String specifiedCargoAgentLocationId;
    private PostalAddress freightForwarderAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getCargoAgentID() {
        return cargoAgentID;
    }

    public void setCargoAgentID(String cargoAgentID) {
        this.cargoAgentID = cargoAgentID;
    }

    public String getSpecifiedCargoAgentLocationId() {
        return specifiedCargoAgentLocationId;
    }

    public void setSpecifiedCargoAgentLocationId(String specifiedCargoAgentLocationId) {
        this.specifiedCargoAgentLocationId = specifiedCargoAgentLocationId;
    }

    public PostalAddress getFreightForwarderAddress() {
        return freightForwarderAddress;
    }

    public void setFreightForwarderAddress(PostalAddress freightForwarderAddress) {
        this.freightForwarderAddress = freightForwarderAddress;
    }
}
