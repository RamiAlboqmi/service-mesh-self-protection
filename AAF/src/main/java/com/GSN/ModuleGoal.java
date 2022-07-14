package com.GSN;

public class ModuleGoal extends Goal {
    private String assessmentProcess;

    public ModuleGoal(){}
    public ModuleGoal(String identifier, String assessmentProcess, String achievementWeight){
        super(identifier, achievementWeight);
        this.assessmentProcess = assessmentProcess;
    }

    @Override
    public void setIdentifier(String identifier) {
        super.setIdentifier(identifier);
    }

    public void setAssessmentProcess(String assessmentProcess) {
        this.assessmentProcess = assessmentProcess;
    }

    @Override
    public void setAchievementWeight(String achievementWeight) {
        super.setAchievementWeight(achievementWeight);
    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }

    public String getAssessmentProcess() {
        return assessmentProcess;
    }

    @Override
    public String getAchievementWeight() {
        return super.getAchievementWeight();
    }
}
