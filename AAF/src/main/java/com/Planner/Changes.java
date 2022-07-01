package com.Planner;

public class Changes {
    private String stateVar;
    private String newState;
    private ChangeCond changeCond;
    private String evidence;
    private String rationale;
    private String operatorType;

    public Changes(String stateVar, String newState, ChangeCond changeCond, String evidence, String rationale, String operatorType) {
        this.stateVar = stateVar;
        this.newState = newState;
        this.changeCond = changeCond;
        this.evidence = evidence;
        this.rationale = rationale;
        this.operatorType = operatorType;
    }

    public String getStateVar() {
        return stateVar;
    }

    public String getNewState() {
        return newState;
    }

    public ChangeCond getChangeCond() {
        return changeCond;
    }

    public String getEvidence() {
        return evidence;
    }

    public String getRationale() {
        return rationale;
    }

    public String getOperatorType() {
        return operatorType;
    }
}
