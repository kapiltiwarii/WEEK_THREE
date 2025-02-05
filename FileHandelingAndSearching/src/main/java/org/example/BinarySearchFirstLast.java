package org.example;

public class BinarySearchFirstLast {

    // Function to find the first occurrence of the target
    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstOccurrence = mid; // Target found, continue searching on  left side
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    // Function to find the last occurrence of the target
    public static int binarySearchLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastOccurrence = mid; // Target found, continue searching on the right side
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }

    // Function to find both the first and last occurrences of the target
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = binarySearchFirst(arr, target);

        if (first == -1) {
            return new int[] {-1}; // Target not found
        }

        int last = binarySearchLast(arr, target);
        return new int[] {first, last};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 6};
        int target = 2;

        int[] result = findFirstAndLast(arr, target);

        if (result[0] == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First and Last Occurrence of " + target + ": " + result[0] + " and " + result[1]);
        }
    }
}
