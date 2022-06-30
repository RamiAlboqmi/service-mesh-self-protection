package com.GSN;

public class OppGoal extends  Goal{
    private String variable;
    private String condition;

    public OppGoal(){}
    public OppGoal(String identifier, String variable, String condition, String achievementWeight){
        super(identifier, achievementWeight);
        this.variable = variable;
        this.condition = condition;
    }

    @Override
    public void setIdentifier(String identifier) {
        super.setIdentifier(identifier);
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public void setAchievementWeight(String achievementWeight) {
        super.setAchievementWeight(achievementWeight);
    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }

    public String getVariable() {
        return variable;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String getAchievementWeight() {
        return super.getAchievementWeight();
    }
}
