package com.mulesoft.iata.typeb.domain;

/**
 * Created by msuarez on 9/13/16.
 */
public class Origin {
    private Address address;
    private String date;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
