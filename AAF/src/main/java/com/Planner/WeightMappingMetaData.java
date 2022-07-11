package com.Planner;

public class WeightMappingMetaData {
    private String ID;
    private String type;
    private String requirement;
    private String condition;
    private String weight;

    public WeightMappingMetaData(String ID, String type,String requirement,String condition, String weight)
    {
        this.ID = ID;
        this.type = type;
        this.weight = weight;
        this.requirement = requirement;
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public String getWeight() {
        return weight;
    }

    public String getID() {
        return ID;
    }

    public String getCondition() {
        return condition;
    }

    public String getRequirement() {
        return requirement;
    }
}
