package com.mulesoft.iata.typeb.domain.fwb.header;

/**
 * Created by msuarez on 9/14/16.
 */
public class SignatoryCarrierAuthentication {
    private String actualDateTime;
    private String signatory;
    private IssueAuthenticationLocation issueAuthenticationLocation;


    public String getActualDateTime() {
        return actualDateTime;
    }

    public void setActualDateTime(String actualDateTime) {
        this.actualDateTime = actualDateTime;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public IssueAuthenticationLocation getIssueAuthenticationLocation() {
        return issueAuthenticationLocation;
    }

    public void setIssueAuthenticationLocation(IssueAuthenticationLocation issueAuthenticationLocation) {
        this.issueAuthenticationLocation = issueAuthenticationLocation;
    }
}
