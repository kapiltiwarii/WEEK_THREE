package org.example;

import java.io.*;

public class ByteToCharacterStream {
    public static void readFileAsCharacterStream(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:/FileHandelingAndSearching/src/main/java/org/example/example.txt"; // Here we store the path of file
        readFileAsCharacterStream(filePath);
    }
}
