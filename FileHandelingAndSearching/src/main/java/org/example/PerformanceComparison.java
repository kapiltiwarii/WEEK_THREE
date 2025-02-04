package org.example;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 100000000;
        String fileName = "D:/FileHandelingAndSearching/src/main/java/org/example/large_text_file.txt";

        // Compare StringBuilder and StringBuffer
        compareStringBuilderAndBuffer(iterations);

        // Compare FileReader and InputStreamReader
        compareFileReaders(fileName);
    }

    public static void compareStringBuilderAndBuffer(int iterations) {
        String text = "hello";

        // Measure StringBuilder time
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 100000000 + " ms");

        // Measure StringBuffer time
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 100000000 + " ms");
    }

    public static void compareFileReaders(String fileName) {
        // Measure FileReader time
        long startTime = System.nanoTime();
        int fileReaderWordCount = countWordsUsingFileReader(fileName);
        long endTime = System.nanoTime();
        System.out.println("FileReader Word Count: " + fileReaderWordCount);
        System.out.println("FileReader Time: " + (endTime - startTime) / 100000000 + " ms");

        // Measure InputStreamReader time
        startTime = System.nanoTime();
        int inputStreamReaderWordCount = countWordsUsingInputStreamReader(fileName);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Word Count: " + inputStreamReaderWordCount);
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 100000000 + " ms");
    }

    public static int countWordsUsingFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by spaces/tabs/newlines
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }
}
