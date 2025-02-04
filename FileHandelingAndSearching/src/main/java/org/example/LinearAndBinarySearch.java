package org.example;

import java.util.Arrays;

public class LinearAndBinarySearch {

    // Function to find the first missing positive integer using Linear Search
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Place each number at its correct index
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with the correct position (arr[arr[i] - 1])
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers are in place, return the next number
    }

    // Function to perform Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found, return index
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};

        // Finding first missing positive integer using Linear Search
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missing);

        // Sorting the array before Binary Search
        Arrays.sort(arr);

        int target = 4;
        int index = binarySearch(arr, target);
        System.out.println("Index of " + target + " (Binary Search): " + index);
    }
}
