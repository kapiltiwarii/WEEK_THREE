package org.example;

import java.util.*;

public class DataStructureSearchComparison {

    private static final int[] TEST_SIZES = {1000, 100000, 1000000};

    // Linear Search on an Array (O(N))
    public static boolean searchArray(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // HashSet Search (O(1) average case)
    public static boolean searchHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // TreeSet Search (O(log N))
    public static boolean searchTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void compareSearchPerformance(int N) {
        Random rand = new Random();
        int target = rand.nextInt(N * 10);  // Random target element

        // Generate random dataset
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int num = rand.nextInt(N * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Measure Array Search Time
        long startTime = System.nanoTime();
        boolean foundArray = searchArray(array, target);
        long timeArray = System.nanoTime() - startTime;

        // Measure HashSet Search Time
        startTime = System.nanoTime();
        boolean foundHashSet = searchHashSet(hashSet, target);
        long timeHashSet = System.nanoTime() - startTime;

        // Measure TreeSet Search Time
        startTime = System.nanoTime();
        boolean foundTreeSet = searchTreeSet(treeSet, target);
        long timeTreeSet = System.nanoTime() - startTime;

        System.out.printf("Dataset Size: %,d | Array: %,.3f ms | HashSet: %,.3f ms | TreeSet: %,.3f ms%n",
                N, timeArray / 1e6, timeHashSet / 1e6, timeTreeSet / 1e6);
    }

    public static void main(String[] args) {
        System.out.println("Comparing Search Performance (Array vs HashSet vs TreeSet):");
        for (int N : TEST_SIZES) {
            compareSearchPerformance(N);
        }
    }
}
