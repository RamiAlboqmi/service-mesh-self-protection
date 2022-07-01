package com.GSN;

public class Goal {
    private String identifier;
    private String achievementWeight;

    public Goal(){}
    public  Goal(String identifier, String achievementWeight)
    {
        this.identifier = identifier;
        this.achievementWeight = achievementWeight;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setAchievementWeight(String achievementWeight) {
        this.achievementWeight = achievementWeight;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getAchievementWeight() {
        return achievementWeight;
    }
}
