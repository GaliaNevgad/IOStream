package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public void reader() throws FileNotFoundException {
        Service service = new Service();
        List<String> rows = new ArrayList<>();
        boolean pathIsCorrect = false;

        while(!pathIsCorrect){
            try{
                rows = service.getLines(path());
            } catch (IOException e) {
                System.out.println("File is failed to load" + e.getMessage() + "\nTry again");
                continue;
            }
            pathIsCorrect = true;
        }
        if(!rows.isEmpty()){
            System.out.println("The sentence, that contains maximum words is: " + findBiggestSentence(rows));
        }else{
            System.out.println("The file is empty");
        }
    }

    public String path(){
        System.out.println("Enter the path to the chosen file");
        return enteredPath();
    }

    public String enteredPath(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public String findBiggestSentence(List<String> lines){
        int maxLen = 0;
        int index = 0;
        for(String line : lines){
            if(line.split(" ").length > maxLen){
                maxLen = line.split(" ").length;
                index = lines.indexOf(line);
            }
        }
        return lines.get(index);
    }
}
