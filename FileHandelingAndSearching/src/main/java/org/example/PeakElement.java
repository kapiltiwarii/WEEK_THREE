package org.example;

public class PeakElement {
    // Function to find a peak element in the array
    public static int findPeak(int[] arr) {
        int n = arr.length;

        // Edge case: If the array has only one element, return it as the peak
        if (n == 1) {
            return arr[0];
        }

        int left = 0, right = n - 1;

        // Binary search for the peak element
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }

            // If the left neighbor is greater, search in the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }

            // If the right neighbor is greater, search in the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // This line will never be reached because a peak will always be found.
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peak = findPeak(arr);
        System.out.println("Peak element: " + peak);
    }
}
