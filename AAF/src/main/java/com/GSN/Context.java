package com.GSN;

public class Context {
    private String identifier;
    private String tailoring;

    public Context() {}

    public Context(String identifier, String tailoring)
    {
        this.identifier = identifier;
        this.tailoring = tailoring;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setTailoring(String tailoring) {
        this.tailoring = tailoring;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getTailoring() {
        return tailoring;
    }

}
