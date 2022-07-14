package com.GSN;

public class Strategy {
    private String identifier;
    private String assessmentProcess;

    public Strategy(){}
    public Strategy(String identifier, String assessmentProcess){
        this.identifier = identifier;
        this.assessmentProcess = assessmentProcess;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setAssessmentProcess(String assessmentProcess) {
        this.assessmentProcess = assessmentProcess;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getAssessmentProcess() {
        return assessmentProcess;
    }
}
