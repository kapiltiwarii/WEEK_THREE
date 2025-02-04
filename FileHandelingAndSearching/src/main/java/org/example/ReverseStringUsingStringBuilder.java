package org.example;

public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        String givenString = "Hello";

        //Calling the function to store the reversed String
        String reversedString = reverseString(givenString);

        System.out.println(reversedString);
    }

    // Method to give reverse string
    public static String reverseString(String givenString) {

        StringBuilder sb = new StringBuilder();

        sb.append(givenString);

        sb.reverse();

        return sb.toString();

    }
}
