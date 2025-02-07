package org.example;

public class FibonacciComparison {
    // Recursive Fibonacci (Exponential Time Complexity: O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity: O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Function to measure execution time
    public static void compareFibonacciPerformance(int N) {
        // Measure Recursive Fibonacci (Only for small N to avoid long execution)
        if (N <= 30) {
            long startTime = System.nanoTime();
            int resultRecursive = fibonacciRecursive(N);
            long recursiveTime = System.nanoTime() - startTime;
            System.out.printf("Fibonacci(%d) = %d | Recursive Time: %,.3f ms%n", N, resultRecursive, recursiveTime / 1e6);
        } else {
            System.out.printf("Fibonacci(%d) = Unfeasible | Recursive Time: Exponential Growth%n", N);
        }

        // Measure Iterative Fibonacci
        long startTime = System.nanoTime();
        int resultIterative = fibonacciIterative(N);
        long iterativeTime = System.nanoTime() - startTime;
        System.out.printf("Fibonacci(%d) = %d | Iterative Time: %,.3f ms%n", N, resultIterative, iterativeTime / 1e6);
    }
    public static void main(String[] args) {
        int [] testCases = {10,30,50};

        System.out.println("Comparing recursive with iterative method for finding fibonacii numbers ");
        for (int N : testCases){
            compareFibonacciPerformance(N);
        }
    }
}
