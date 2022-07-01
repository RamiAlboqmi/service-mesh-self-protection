package com.Planner;

public class ChangeCond {
    private String newVar;
    private String newFunc;

    public ChangeCond(String newVar, String newFunc)
    {
        this.newVar = newVar;
        this.newFunc = newFunc;
    }

    public void setNewVar(String newVar) {
        this.newVar = newVar;
    }

    public void setNewFunc(String newFunc) {
        this.newFunc = newFunc;
    }

    public String getNewVar() {
        return newVar;
    }

    public String getNewFunc() {
        return newFunc;
    }
}
