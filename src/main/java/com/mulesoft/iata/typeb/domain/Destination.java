package com.mulesoft.iata.typeb.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msuarez on 9/13/16.
 */
public class Destination {
    private String priority;
    private List<Address> addresses = new ArrayList<>();

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
