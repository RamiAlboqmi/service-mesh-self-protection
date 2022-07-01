package com.Planner;

public class Impact {
    private String provision;
    private String condition;
    private double impact;

    public Impact(String provision,String condition, double impact)
    {
        this.provision = provision;
        this.condition = condition;
        this.impact = impact;
    }



    public void setImpact(double im)
    {
        this.impact = im;
    }
    public double getImpact() {
        return impact;
    }

    public String getProvision() {
        return provision;
    }

    public String getCondition() {
        return condition;
    }

}
