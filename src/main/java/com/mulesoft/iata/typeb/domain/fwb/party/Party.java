package com.mulesoft.iata.typeb.domain.fwb.party;

/**
 * Created by msuarez on 9/14/16.
 */
public class Party {
    private String name;
    private PostalAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostalAddress getAddress() {
        return address;
    }

    public void setAddress(PostalAddress address) {
        this.address = address;
    }
}
