package com.Operators;


import com.SACInstance.*;
import com.GSN.OppGoal;
import com.GSN.Solution;
import com.GSN.Strategy;
import com.GSN.SupportedBy;
import com.Planner.Changes;
import com.Planner.Impact;

import java.util.ArrayList;
import java.util.List;

public class supportOperator {

    private InstantiateSAC assuranceCaseInstance;
    private List<Impact> impactTableList;

    public supportOperator(InstantiateSAC assuranceCaseInstance,List<Impact> impactTableList) {
        this.assuranceCaseInstance = assuranceCaseInstance;
        this.impactTableList = impactTableList;
    }

    public void EvoluteSACInstance(Changes changes) {
        if (changes.getOperatorType().equals("Support")) {
            String stVar = changes.getStateVar().trim();
            String newSt = changes.getNewState().trim();
            String newVar = changes.getChangeCond().getNewVar().trim();
            String newFunc = changes.getChangeCond().getNewFunc().trim();
            String evidence = changes.getEvidence().trim();
            List<OppGoal> supGoals = new ArrayList<>();
            List<Strategy> subStrategies =  new ArrayList<>();
            List<Solution> subSolutions = new ArrayList<>();
            List<SupportedBy> subSupported = new ArrayList<>();


            int count=0;
            double impact = -1.0;

            for (Impact impactTable : this.impactTableList) {

                String prov = impactTable.getProvision().trim();
                String cond = impactTable.getCondition().trim();

                if (prov.equals(stVar) && cond.equals(newSt)) {
                    impact = impactTable.getImpact();
                    break;
                }
            }

            for (OppGoal oppGoal : this.assuranceCaseInstance.getOppGoals()) {
                if (oppGoal.getVariable().equals(stVar)) {
                    if (impact >= 0.0) {
                        count++;
                        oppGoal.setAchievementWeight(String.valueOf(impact));
                        subSupported.add(new SupportedBy(oppGoal.getIdentifier(),
                                oppGoal.getIdentifier()+"(S"+count+")"));
                        subStrategies.add(new Strategy(oppGoal.getIdentifier()+"(S"+count+")",newFunc));
                        subSupported.add(new SupportedBy(oppGoal.getIdentifier()+"(Sub"+count+")",
                                oppGoal.getIdentifier()+"(S"+count+")"));
                        subSupported.add(new SupportedBy(oppGoal.getIdentifier()+"(S"+count+")",
                                oppGoal.getIdentifier()+"(Sub"+count+")"));
                        supGoals.add(new OppGoal(oppGoal.getIdentifier()+"(Sub"+count+")", newVar, newSt,String.valueOf(impact)));
                        subSupported.add(new SupportedBy( oppGoal.getIdentifier()+"(Sub"+count+")",
                                oppGoal.getIdentifier()+"(EVD"+count+")"));
                        subSolutions.add(new Solution(oppGoal.getIdentifier()+"(EVD"+count+")",evidence));
                    }
                }
            }
            for (OppGoal supGoal: supGoals) {

                this.assuranceCaseInstance.getOppGoals().add(supGoal);
            }
            for (Strategy subStrategy: subStrategies) {
                this.assuranceCaseInstance.getStrategies().add(subStrategy);
            }
            for (Solution sol:subSolutions) {
                this.assuranceCaseInstance.getSolutions().add(sol);
            }
            for (SupportedBy sup: subSupported) {
                this.assuranceCaseInstance.getSupportedByLinks().add(sup);
            }
        }
    }
}

