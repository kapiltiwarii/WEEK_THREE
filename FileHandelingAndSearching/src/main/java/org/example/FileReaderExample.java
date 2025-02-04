package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "D:/FileHandelingAndSearching/src/main/java/org/example/example.txt"; // Here we store the path of file

        //
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)){
             String line ;
             while ((line = br.readLine()) != null){
                 System.out.println(line);
             }
        }
       catch (IOException e){
           System.out.println("An error occured "+ e.getMessage());
       }


    }
}
