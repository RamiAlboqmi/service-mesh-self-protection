package com.AssessmentMetric;


import com.GSN.MainGoal;
import com.GSN.ProvidesRequires;
import com.GSN.SupportedBy;
import com.SACInstance.InstantiateSAC;


public class CalculateSatisficingWeight {
    private InstantiateSAC assuranceCaseInstance;

    public CalculateSatisficingWeight(InstantiateSAC assuranceCaseInstance) {
        this.assuranceCaseInstance = assuranceCaseInstance;
    }

    public double calculateSatisficingWeight() {

        double sl = 0.0;
        double totalSL = 0.0;
        int i = 0;

        for (MainGoal mainGoal : this.assuranceCaseInstance.getMainGoals()) {
            sl = 0.0;
            i = 0;
            String id = mainGoal.getIdentifier().toString();

            for (SupportedBy links : this.assuranceCaseInstance.getSupportedByLinks()) {

                if (links instanceof ProvidesRequires) {

                    ProvidesRequires a = (ProvidesRequires) links;

                    if (a.getSource().trim().equals(id) ) {

                        for (MainGoal awayGoal : this.assuranceCaseInstance.getMainGoals()) {
                            if (awayGoal.getIdentifier().equals(a.getDestination())) {

                                i++;
                                sl += Double.parseDouble(awayGoal.getAchievementWeight());
                            }
                        }
                    }
                }
            }
            if (i > 0) {
                sl = (sl + Double.parseDouble(mainGoal.getAchievementWeight())) / (i + 1);
                totalSL += sl;

            }
            else
            {
                sl = Double.parseDouble(mainGoal.getAchievementWeight());
                totalSL += sl;
            }
          //  System.out.println(mainGoal.getIdentifier()+" Satisficing level " + sl );

        }

        return totalSL;
    }


}
