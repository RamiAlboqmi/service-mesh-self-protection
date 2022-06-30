package com.Planner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImpactTable {

    private List<Impact> impactList = new ArrayList<>();
    public ImpactTable(String fileName)
    {

        String line = null;

        try {
            FileReader fileReader = new FileReader("./"+fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {


                String[] info = line.split(";");
                Impact impact = new Impact(info[0],info[1],Double.valueOf(info[2]));
                impactList.add(impact);

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

    public List<Impact> getImpactList() {
        return impactList;
    }
}
