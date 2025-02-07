package org.example;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search (requires to be sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void compareSearchPerformance(int N) {
        Random rand = new Random();
        int[] data = new int[N];

        // Fill array with random numbers
        for (int i = 0; i < N; i++) {
            data[i] = rand.nextInt(N * 10);
        }

        // Select a random target
        int target = data[rand.nextInt(N)];

        // Measure Linear Search time
        long startTime = System.nanoTime();
        linearSearch(data, target);
        long linearTime = System.nanoTime() - startTime;

        // Sort for Binary Search
        Arrays.sort(data);

        // Measure Binary Search time
        startTime = System.nanoTime();
        binarySearch(data, target);
        long binaryTime = System.nanoTime() - startTime;

        // Print results
        System.out.println("Dataset Size: "+N+ " | " + "Linear Search: "+ linearTime / 1e6+"ms"+ " | "+ "Binary Search: "+binaryTime / 1e6+ "ms" );
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};

        System.out.println("Comparing Linear Search vs. Binary Search:");
        for (int N : datasetSizes) {
            compareSearchPerformance(N);
        }
    }
}
