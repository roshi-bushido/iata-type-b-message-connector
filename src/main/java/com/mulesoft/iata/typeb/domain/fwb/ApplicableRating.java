package com.mulesoft.iata.typeb.domain.fwb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msuarez on 9/14/16.
 */
public class ApplicableRating {
    private String typeCode;
    private List<ConsignmentItem> items = new ArrayList<>();

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public List<ConsignmentItem> getItems() {
        return items;
    }

    public void setItems(List<ConsignmentItem> items) {
        this.items = items;
    }
}
