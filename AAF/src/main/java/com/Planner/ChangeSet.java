package com.Planner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ChangeSet {
    private List<Plan> plans = new ArrayList<>();

    public ChangeSet(String fileName)
    {
        String line = null;
        List<Changes> changeSet = null;

        try {

            FileReader fileReader = new FileReader("./"+fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i=0;
            while((line = bufferedReader.readLine()) != null) {
                String stateVar = "";
                String newState = "";
                ChangeCond changeCond = null;
                String evidence = "";
                String rationale = "";
                String operatorType = "";

                Plan plan=null;
                if(line.charAt(0)=='{'){
                    i++;
                    changeSet = new ArrayList<>();
                }
                if(line.charAt(line.length()-1)=='}')
                {
                    plan = new Plan(i, changeSet);
                    this.plans.add(plan);
                }

                line = line.replace("{","");
                line = line.replace("}","");
                line = line.substring(0,line.length()-1);

                //System.out.println(line);

                String[] info = line.split(";");
                stateVar = info[0].substring(1,info[0].length());
                newState = info[1];

                if(!info[2].equals("null")) {
                    String condition = info[2].substring(1, info[2].length() - 1);
                    String[] changeCondition = condition.split(",");

                    String newVar = changeCondition[0];
                    String newFunc = condition.substring(newVar.length()+1,condition.length());
                    changeCond = new ChangeCond(newVar,newFunc);
                    if(newVar.equals("null") && !newFunc.equals("null"))
                    {
                        operatorType = "Substitute";
                    }
                    else if(!newVar.equals("null") && !newFunc.equals("null"))
                    {
                        operatorType = "Support";
                    }
                    else if(newVar.equals("null") && newFunc.equals("null"))
                    {
                        operatorType = "ChangeVal";
                    }
                }

                rationale = info[4];
                Changes chng = new Changes(stateVar,newState, changeCond,evidence,rationale,operatorType);

                changeSet.add(chng);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public List<Plan> getPlans() {
        return plans;
    }
}
