package org.example;

public class LinearSearchSentence {
    public static String searchSentence(String[] sentences, String searchWord) {
        for (int i = 0; i < sentences.length; i++) {
            // words array to store the words of sentences
            String[] words = sentences[i].split("\\s+");

            for (int j = 0; j < words.length; j++) {
                if (words[j].equals(searchWord)){ // to compare each words with target word
                    return sentences[i];
                }
            }

        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Hello capgemini team",
                "Here we are studying Java fullstack course",
                "Bridglabz is going to train us",
                "It is a very interesting Program"
        };

        String searchWord = "Java";

        String result = searchSentence(sentences, searchWord);

        System.out.println(result);
    }
}
