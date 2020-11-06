package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    BufferedReader bufferedReader = null;

    public List<String> getLines(String scr) throws IOException {
        List<String> rows = new ArrayList<>();
        String row;

        try{
            bufferedReader = new BufferedReader(new FileReader(scr));
            while((row = bufferedReader.readLine()) != null){
                rows.add(row);
            }
        }finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
        return rows;
    }
}
