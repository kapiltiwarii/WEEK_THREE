
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
    // Method to count the occurance of target word
    public static int countOccurenceOfWord(String filePath, String targetWord) {
        int count =0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr))
        {
            String line ;
            while ((line = br.readLine())!=null){
                String[] words = line.split(" "); // Split by whitespace
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equalsIgnoreCase(targetWord)){ // Case-insensitive match
                        count++;
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("An error occurred"+ e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "D:/FileHandelingAndSearching/src/main/java/org/example/example.txt"; // Here we store the path of file
        String targetWord = "Hello";

        int occurrence = countOccurenceOfWord(filePath,targetWord);

        System.out.println("The word "+targetWord+" is occurred "+occurrence+" times");
    }
}

