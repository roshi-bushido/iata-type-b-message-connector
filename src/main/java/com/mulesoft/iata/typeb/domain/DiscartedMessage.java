package com.mulesoft.iata.typeb.domain;

/**
 * Created by msuarez on 9/13/16.
 */
public class DiscartedMessage {
    private String content;

    public DiscartedMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
