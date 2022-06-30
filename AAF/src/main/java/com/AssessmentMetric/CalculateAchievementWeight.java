package com.AssessmentMetric;


import com.GSN.*;
import com.SACInstance.InstantiateSAC;

public class CalculateAchievementWeight {
    public void assignAchievementWeight(InstantiateSAC assuranceCaseInstance) {
        double aw = 0;
        int i = 0;
        for (OppGoal oppGoal : assuranceCaseInstance.getOppGoals()) {
            aw = 0;
            i = 0;


            for (SupportedBy supportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                if (supportedbyLinks.getSource().equals(oppGoal.getIdentifier())) {


                    for (Strategy strategies : assuranceCaseInstance.getStrategies()) {
                        if (strategies.getIdentifier().equals(supportedbyLinks.getDestination())) {

                            for (SupportedBy secondarySupportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                                if (secondarySupportedbyLinks.getSource().equals(strategies.getIdentifier())) {
                                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {

                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }
                                }
                            }
                        }
                    }


                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {

                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }
                }
            }

            if (i > 0) {
                aw = aw / i;
                oppGoal.setAchievementWeight(String.valueOf(aw));
            }
          //  System.out.println(oppGoal.getIdentifier() + " Achievement Weight "+ oppGoal.getAchievementWeight());
        }


        // module goal

        for (ModuleGoal moduleGoal : assuranceCaseInstance.getModuleGoals()) {
            aw = 0;
            i = 0;

            for (SupportedBy supportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                if (supportedbyLinks.getSource().equals(moduleGoal.getIdentifier())) {
                    for (Strategy strategies : assuranceCaseInstance.getStrategies()) {
                        if (strategies.getIdentifier().equals(supportedbyLinks.getDestination())) {


                            for (SupportedBy secondarySupportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                                if (secondarySupportedbyLinks.getSource().equals(strategies.getIdentifier())) {
                                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {

                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());

                                        }
                                    }
                                }
                            }
                        }
                    }


                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }
                }
            }

            if (i > 0) {
                aw = aw / i;
                moduleGoal.setAchievementWeight(String.valueOf(aw));
            }

           // System.out.println(moduleGoal.getIdentifier() + " Achievement Weight "+ moduleGoal.getAchievementWeight());
        }


        // sub goal

        for (ReqGoal subGoal : assuranceCaseInstance.getSubGoals()) {
            aw = 0;
            i = 0;

            for (SupportedBy supportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                if (supportedbyLinks.getSource().equals(subGoal.getIdentifier())) {


                    for (Strategy strategies : assuranceCaseInstance.getStrategies()) {
                        if (strategies.getIdentifier().equals(supportedbyLinks.getDestination())) {

                            for (SupportedBy secondarySupportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                                if (secondarySupportedbyLinks.getSource().equals(strategies.getIdentifier())) {

                                    for (ReqGoal childGoal : assuranceCaseInstance.getSubGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {
                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }


                                    for (ModuleGoal childGoal : assuranceCaseInstance.getModuleGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {

                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }

                                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {
                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }
                                }
                            }
                        }
                    }


                    for (ReqGoal childGoal : assuranceCaseInstance.getSubGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }

                    for (ModuleGoal childGoal : assuranceCaseInstance.getModuleGoals()) {

                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {

                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }

                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }
                }
            }

            if (i > 0) {
                aw = aw / i;
                subGoal.setAchievementWeight(String.valueOf(aw));
            }
           // System.out.println(subGoal.getIdentifier() + " Achievement Weight "+ subGoal.getAchievementWeight());

        }


        // Main goal
        for (MainGoal mainGoal : assuranceCaseInstance.getMainGoals()) {
            aw = 0;
            i = 0;
            for (SupportedBy supportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                if (supportedbyLinks.getSource().equals(mainGoal.getIdentifier())) {


                    for (Strategy strategies : assuranceCaseInstance.getStrategies()) {
                        if (strategies.getIdentifier().equals(supportedbyLinks.getDestination())) {

                            for (SupportedBy secondarySupportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                                if (secondarySupportedbyLinks.getSource().equals(strategies.getIdentifier())) {

                                    for (ReqGoal childGoal : assuranceCaseInstance.getSubGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {
                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }


                                    for (ModuleGoal childGoal : assuranceCaseInstance.getModuleGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {
                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }

                                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                                        if (childGoal.getIdentifier().equals(secondarySupportedbyLinks.getDestination())) {
                                            i++;
                                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                                        }
                                    }
                                }
                            }
                        }
                    }


                    for (ReqGoal childGoal : assuranceCaseInstance.getSubGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }

                    for (ModuleGoal childGoal : assuranceCaseInstance.getModuleGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }

                    for (OppGoal childGoal : assuranceCaseInstance.getOppGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            i++;
                            aw += Double.parseDouble(childGoal.getAchievementWeight());
                        }
                    }
                }
            }

            if (i > 0) {
                aw = aw / i;
                mainGoal.setAchievementWeight(String.valueOf(aw));
            }
          //  System.out.println(mainGoal.getIdentifier() + " Achievement Weight "+ mainGoal.getAchievementWeight());

        }

       // System.out.println("Calculate Assessment Metrics ");
        for (MainGoal mainGoal : assuranceCaseInstance.getMainGoals()) {
            aw = 0;
            for (SupportedBy supportedbyLinks : assuranceCaseInstance.getSupportedByLinks()) {
                if (supportedbyLinks.getSource().equals(mainGoal.getIdentifier())) {
                    for (MainGoal childGoal : assuranceCaseInstance.getMainGoals()) {
                        if (childGoal.getIdentifier().equals(supportedbyLinks.getDestination())) {
                            aw = (Double.parseDouble(mainGoal.getAchievementWeight())+Double.parseDouble(childGoal.getAchievementWeight()))/2;
                            mainGoal.setAchievementWeight(String.valueOf(aw));

                         //   System.out.println(mainGoal.getIdentifier() + " Achievement Weight "+ mainGoal.getAchievementWeight());
                        }
                    }
                }
            }
        }
    }
}

