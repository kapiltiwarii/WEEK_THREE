package org.example;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    // Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;  // Optimization: Stop if already sorted
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Function to measure sorting time
    public static void compareSortingPerformance(int N) {
        Random rand = new Random();
        int[] originalArray = new int[N];

        for (int i = 0; i < N; i++) {
            originalArray[i] = rand.nextInt(N * 10);
        }

        // Measure Bubble Sort (only for small N)
        if (N <= 10000) {
            int[] bubbleArray = Arrays.copyOf(originalArray, N);
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long bubbleTime = System.nanoTime() - startTime;
            System.out.printf("Dataset Size: %,d | Bubble Sort: %,.3f ms%n", N, bubbleTime / 1e6);
        } else {
            System.out.printf("Dataset Size: %,d | Bubble Sort: Unfeasible%n", N);
        }

        // Measure Merge Sort
        int[] mergeArray = Arrays.copyOf(originalArray, N);
        long startTime = System.nanoTime();
        mergeSort(mergeArray, 0, N - 1);
        long mergeTime = System.nanoTime() - startTime;
        System.out.printf("Dataset Size: %,d | Merge Sort: %,.3f ms%n", N, mergeTime / 1e6);

        // Measure Quick Sort
        int[] quickArray = Arrays.copyOf(originalArray, N);
        startTime = System.nanoTime();
        quickSort(quickArray, 0, N - 1);
        long quickTime = System.nanoTime() - startTime;
        System.out.printf("Dataset Size: %,d | Quick Sort: %,.3f ms%n", N, quickTime / 1e6);
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};

        System.out.println("Comparing Sorting Algorithms (Bubble Sort, Merge Sort, Quick Sort):");
        for (int N : datasetSizes) {
            compareSortingPerformance(N);
        }
    }
}

