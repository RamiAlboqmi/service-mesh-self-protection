package com.GSN;

public class ReqGoal extends  Goal{
    private String assessmentProcess;
    private String functionalReq;

    public ReqGoal(){}
    public ReqGoal(String identifier, String assessmentProcess, String functionalReq, String acievementWeight)
    {
        super(identifier,acievementWeight);
        this.assessmentProcess = assessmentProcess;
        this.functionalReq = functionalReq;
    }

    public void setAssessmentProcess(String assessmentProcess) {
        this.assessmentProcess = assessmentProcess;
    }

    public void setFunctionalReq(String functionalReq) {
        this.functionalReq = functionalReq;
    }

    @Override
    public void setIdentifier(String identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public void setAchievementWeight(String achievementWeight) {
        super.setAchievementWeight(achievementWeight);
    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public String getAchievementWeight() {
        return super.getAchievementWeight();
    }

    public String getAssessmentProcess() {
        return assessmentProcess;
    }

    public String getFunctionalReq() {
        return functionalReq;
    }
}
