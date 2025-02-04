package org.example;

public class StringBufferConcatenation {
    // Method to concatenate string in stringbuffer
    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer();

        // loop to iterate in word array and append the words in buffer
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello","Kalpesh","Welcome","to","Capgemini"};
        System.out.println(concatenateStrings(words));
    }
}
