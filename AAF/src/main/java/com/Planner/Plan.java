package com.Planner;

import java.util.List;

public class Plan {
    private int id;
    private List<Changes> changesList;

    public Plan(int id, List<Changes> changesList)
    {
        this.id = id;
        this.changesList = changesList;
    }

    public int getId() {
        return id;
    }

    public List<Changes> getChangesList() {
        return changesList;
    }
}
