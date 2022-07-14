package com.GSN;

public class InContextOf extends Link {
    public InContextOf(){}
    public InContextOf(String source, String destination){
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
