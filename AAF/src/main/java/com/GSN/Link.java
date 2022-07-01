package com.GSN;

public class Link {
    private String source;
    private String destination;

    public Link(){}
    public Link(String source, String destination){
        this.source = source;
        this.destination = destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
