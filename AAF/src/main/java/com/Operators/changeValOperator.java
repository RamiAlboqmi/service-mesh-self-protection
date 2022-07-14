package com.Operators;

import com.SACInstance.*;
import com.GSN.Context;
import com.GSN.OppGoal;
import com.Planner.Changes;
import com.Planner.Impact;

import java.util.List;

public class changeValOperator {

    private InstantiateSAC assuranceCaseInstance;
    private List<Impact> impactTableList;


    public changeValOperator(InstantiateSAC assuranceCaseInstance,List<Impact> impactTableList) {

        this.assuranceCaseInstance = assuranceCaseInstance;
        this.impactTableList = impactTableList;
    }

    public void EvoluteSACInstance(Changes changes) {

        if (changes.getOperatorType().equals("ChangeVal")) {

            String stVar = changes.getStateVar().trim();
            String newSt = changes.getNewState().trim();
            double impact = -1.0;

            for (Impact impactTable : this.impactTableList) {
                String prov = impactTable.getProvision().trim();
                String cond = impactTable.getCondition().trim();

                if (prov.equals(stVar) && cond.equals(newSt)) {

                    impact = impactTable.getImpact();
                    break;
                }
            }

            for (Context context : this.assuranceCaseInstance.getContexts()) {
                if (!context.getTailoring().equals("")) {


                    String tailoringVal = context.getTailoring().trim();
                    String[] Vars = tailoringVal.split("=");

                    if (Vars[0].trim().equals(stVar.trim())) {

                        context.setTailoring(Vars[0] + ":" + changes.getNewState());
                        break;
                    }
                }
            }

            for (OppGoal oppGoal : this.assuranceCaseInstance.getOppGoals()) {
                if (oppGoal.getVariable().trim().equals(stVar.trim())) {

                    if (impact >= 0.0) {
                        oppGoal.setCondition(newSt);
                        oppGoal.setAchievementWeight(String.valueOf(impact));
                        //System.out.println(oppGoal.getIdentifier() + " "+ oppGoal.getAchievementWeight());
                    }
                }
            }
        }
    }


}

