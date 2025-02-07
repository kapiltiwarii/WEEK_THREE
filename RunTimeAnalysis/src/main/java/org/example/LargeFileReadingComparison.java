package org.example;

import java.io.*;

public class LargeFileReadingComparison {

    // FileReader (Character Stream) - Reads file character by character
    public static long readUsingFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) { /* Reading character by character */ }
        }
        return System.nanoTime() - startTime;
    }

    // InputStreamReader (Byte Stream) - Reads bytes and converts to characters
    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) { /* Reading character by character */ }
        }
        return System.nanoTime() - startTime;
    }

    public static void compareReadingPerformance(String filePath) throws IOException {
        System.out.println("Comparing FileReader vs InputStreamReader for Large File Reading:");

        // Measure FileReader time
        long timeFileReader = readUsingFileReader(filePath) / 100000000; // Convert to milliseconds
        System.out.println("FileReader Time: "+timeFileReader+"ms");

        // Measure InputStreamReader time
        long timeInputStreamReader = readUsingInputStreamReader(filePath) / 100000000; // Convert to milliseconds
        System.out.println("InputStreamReader Time: "+timeInputStreamReader+"ms");
    }

    public static void main(String[] args) {
        String filePath = "D:\\WEEK3\\RuntimeAnalysis\\src\\main\\java\\org\\example/sample_100MB.txt"; // Ensure the file exists in the project directory

        try {
            compareReadingPerformance(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
