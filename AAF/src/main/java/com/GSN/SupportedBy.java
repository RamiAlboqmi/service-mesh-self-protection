package com.GSN;

public class SupportedBy extends Link {
    public SupportedBy(){}
    public SupportedBy(String source, String destination){
        super(source, destination);
    }

    @Override
    public void setSource(String source) {
        super.setSource(source);
    }

    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    @Override
    public String getSource() {
        return super.getSource();
    }

    @Override
    public String getDestination() {
        return super.getDestination();
    }
}
