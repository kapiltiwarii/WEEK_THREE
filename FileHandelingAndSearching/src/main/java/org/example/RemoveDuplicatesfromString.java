package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesfromString {

    public static String removeDuplicateChars(String givenString) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < givenString.length(); i++) {
            if (!seen.contains(givenString.charAt(i))){
                sb.append(givenString.charAt(i));
                seen.add(givenString.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // Taking a String from a user
        System.out.println("Enter the String  : ");
        Scanner input = new Scanner(System.in);
        String givenString = input.nextLine();

        String removedCopy = removeDuplicateChars(givenString);

        System.out.println(removedCopy);
    }
}
