package com.Planner;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class DecisionOutput {
    public void GenDecisionOutput(String dec) {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("decision", dec);
        try {
            FileWriter file = new FileWriter("./output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}