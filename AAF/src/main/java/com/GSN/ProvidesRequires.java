package com.GSN;

public class ProvidesRequires extends SupportedBy {
    private String provisionSet;

    public ProvidesRequires(){}
    public ProvidesRequires(String source, String destination, String requiresProvisionSet){
        super(source, destination);
        this.provisionSet = requiresProvisionSet;
    }

    @Override
    public void setSource(String source) {
        super.setSource(source);
    }

    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    public void setProvisionSet(String providesProvisionSet) {
        this.provisionSet = providesProvisionSet;
    }



    @Override
    public String getSource() {
        return super.getSource();
    }

    @Override
    public String getDestination() {
        return super.getDestination();
    }



    public String getProvisionSet() {
        return provisionSet;
    }
}
