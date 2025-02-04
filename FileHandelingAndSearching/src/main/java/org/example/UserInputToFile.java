package org.example;

import java.io.*;

public class UserInputToFile {
    public static void writeUserInputToFile(String fileName) {
        // Using try-with-resources to automatically close resources
        try (InputStreamReader isr = new InputStreamReader(System.in); // Reads bytes from console and converts to characters
             BufferedReader br = new BufferedReader(isr); // Wraps InputStreamReader for efficient reading
             FileWriter fw = new FileWriter(fileName, true)) // FileWriter in append mode (true)
        {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String line;
            while (true) { // Read user input until "exit" is entered
             line = br.readLine();
             if (line.equalsIgnoreCase("exit")){
                 break;
             }
             fw.write(line);
             fw.write(System.lineSeparator());
            }


            System.out.println("User input has been saved to " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle exceptions
        }
    }

    public static void main(String[] args) {
        String fileName = "D:/FileHandelingAndSearching/src/main/java/org/example/example.txt"; // Here we store the path of file
        writeUserInputToFile(fileName); // Call the method to read input and write to file
    }
}
