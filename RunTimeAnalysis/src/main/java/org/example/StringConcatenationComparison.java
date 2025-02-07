package org.example;

public class StringConcatenationComparison {

    private static final int[] TEST_SIZES = {1000, 10000, 1000000};

    // Using String (Inefficient O(N²))
    public static long testStringConcatenation(int N) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < N; i++) {
            result += "a";  // Creates a new object each time
        }
        return System.nanoTime() - startTime;
    }

    // Using StringBuilder (Efficient O(N))
    public static long testStringBuilderConcatenation(int N) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }

    // Using StringBuffer (Thread-safe, O(N))
    public static long testStringBufferConcatenation(int N) {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }

    public static void compareConcatenationPerformance() {
        System.out.println("Comparing String Concatenation Performance (String vs StringBuilder vs StringBuffer):");

        for (int N : TEST_SIZES) {
            if (N <= 10000) { // Avoid long runtime for large N using String
                long timeString = testStringConcatenation(N) / 1_000_000;
                System.out.printf("Operations: %,d | String: %,d ms%n", N, timeString);
            } else {
                System.out.printf("Operations: %,d | String: Unfeasible%n", N);
            }

            long timeStringBuilder = testStringBuilderConcatenation(N) / 1_000_000;
            long timeStringBuffer = testStringBufferConcatenation(N) / 1_000_000;

            System.out.printf("Operations: %,d | StringBuilder: %,d ms | StringBuffer: %,d ms%n",
                    N, timeStringBuilder, timeStringBuffer);
        }
    }

    public static void main(String[] args) {
        compareConcatenationPerformance();
    }
}
