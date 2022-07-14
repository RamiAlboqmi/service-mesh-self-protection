package com.GSN;

import com.Planner.Impact;

public class Solution {
    private String identifier;
    private String assessment;
    private Impact impactFactor;

    public Solution() {}

    public Solution(String identifier, String assessment, Impact impactFactor)
    {
        this.identifier = identifier;
        this.assessment = assessment;
        this.impactFactor = impactFactor;
    }

    public Solution(String s, String evidence) {
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getAssessment() {
        return assessment;
    }

    public Impact getImpactFactor()
    {
        return impactFactor;
    }

}
