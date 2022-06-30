package com.Planner;

import com.AssessmentMetric.CalculateAchievementWeight;
import com.AssessmentMetric.CalculateSatisficingWeight;
import com.SACInstance.InstantiateSAC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MAPE {
    public String MAPE_response(String numOfRequest, String newUser) {
        double totalSL = 0.0;
        DecisionOutput decisionOutput = new DecisionOutput();
        List<Impact> impactTableList = new ImpactTable("./config/Impact.txt").getImpactList();

        ChangeSet changeSet = new ChangeSet("./config/ChangeSet1.txt");
        if(Integer.valueOf(numOfRequest) > 3 && newUser.equals("false") )
        {
            changeSet = new ChangeSet("./config/ChangeSet1.txt");
        }
        else if(Integer.valueOf(numOfRequest) > 3 && newUser.equals("true"))
        {
            changeSet = new ChangeSet("./config/ChangeSet2.txt");
        }
        else if(Integer.valueOf(numOfRequest) > 1 && Integer.valueOf(numOfRequest)<=3 && newUser.equals("false"))
        {
            changeSet = new ChangeSet("./config/ChangeSet3.txt");
        }
        else if(Integer.valueOf(numOfRequest) > 1 && Integer.valueOf(numOfRequest)<=3 && newUser.equals("true"))
        {
            changeSet = new ChangeSet("./config/ChangeSet4.txt");
        }
        else if(Integer.valueOf(numOfRequest) ==1 && newUser.equals("true"))
        {
            changeSet = new ChangeSet("./config/ChangeSet5.txt");
        }
        else if(Integer.valueOf(numOfRequest) ==1 && newUser.equals("false"))
        {
            changeSet = new ChangeSet("./config/ChangeSet6.txt");
        }


        File file;
        int planID = 0;

        try {

            String content = "";

            File newfile = new File("./config/PlanRank.txt");
            file = newfile;

            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            for (Plan plan : changeSet.getPlans()) {
                planID++;
                InstantiateSAC assuranceCaseInstance = new InstantiateSAC("./config/AC-4.xml");
                assuranceCaseInstance.loadXML();
                for (Changes change : plan.getChangesList()) {
                        ChangeEvidence operation = new ChangeEvidence(assuranceCaseInstance, impactTableList);
                        operation.EvoluteSACInstance(change);
                }
                CalculateAchievementWeight calAW = new CalculateAchievementWeight();
                calAW.assignAchievementWeight(assuranceCaseInstance);

                InstantiateSAC updateAC = new InstantiateSAC();
                updateAC.generateAssuranceCase("./config/AC-4"+" plan" + plan.getId(), assuranceCaseInstance);
                CalculateSatisficingWeight satisficingWeight = new CalculateSatisficingWeight(assuranceCaseInstance);

                 totalSL = satisficingWeight.calculateSatisficingWeight();
                content = "Plan"+ planID + ":" + totalSL;
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.newLine();
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String returnVal = "";
        if(totalSL<0.8) {
            returnVal = "block";
            decisionOutput.GenDecisionOutput("block");
        }
        else if(totalSL >=0.8 && totalSL<0.9) {
            returnVal = "V1";
            decisionOutput.GenDecisionOutput("V1");
        }
        else if(totalSL >= 0.9 && totalSL<1.0) {
            returnVal = "V2";
            decisionOutput.GenDecisionOutput("V2");
        }
        else if (totalSL==1.0) {
            returnVal = "V3";
            decisionOutput.GenDecisionOutput("V3");
        }
        return returnVal;
    }
}
