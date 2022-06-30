package com.GSN;

public class MainGoal extends Goal {
    private String family;
    private String number;
    private String implementedBy;
    private String controlAction;
    private String baselineAllocation;
    private String provisionSet;

    public MainGoal( String family,String number,String identifier,String implementedBy, String controlAction,
                String baselineAllocation, String provisionSet, String achievementWeight){
        super(identifier, achievementWeight);
        this.family = family;
        this.number = number;
        this.implementedBy = implementedBy;
        this.controlAction = controlAction;
        this.baselineAllocation = baselineAllocation;
        this.provisionSet = provisionSet;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setImplementedBy(String implementedBy) {
        this.implementedBy = implementedBy;
    }

    public void setBaselineAllocation(String baselineAllocation) {
        this.baselineAllocation = baselineAllocation;
    }

    public void setControlAction(String controlAction) {
        this.controlAction = controlAction;
    }

    public void setProvisionSet(String provisionSet) {
        this.provisionSet = provisionSet;
    }

    @Override
    public void setIdentifier(String identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public void setAchievementWeight(String achievementWeight) {
        super.setAchievementWeight(achievementWeight);
    }

    public String getFamily() {
        return family;
    }

    public String getNumber() {
        return number;
    }

    public String getImplementedBy() {
        return implementedBy;
    }

    public String getControlAction() {
        return controlAction;
    }

    public String getBaselineAllocation() {
        return baselineAllocation;
    }

    public String getProvisionSet() {
        return provisionSet;
    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public String getAchievementWeight() {
        return super.getAchievementWeight();
    }
}
