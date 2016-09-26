package com.mulesoft.iata.typeb.domain;

/**
 * Created by msuarez on 9/13/16.
 */
public class Address {
    private String origin;
    private String function;
    private String airline;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
