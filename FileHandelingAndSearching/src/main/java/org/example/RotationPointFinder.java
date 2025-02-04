package org.example;

public class RotationPointFinder {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;  // Avoid overflow

            // Check if mid element is greater than the rightmost element
            if (arr[mid] > arr[right]) {
                // The rotation point is in the right half
                left = mid + 1;
            } else {
                // The rotation point is in the left half (including mid)
                right = mid;
            }
        }

        // Left will be at the rotation point
        return arr[left];
    }

    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3};

        int rotationPoint = findRotationPoint(rotatedArray);
        System.out.println("Rotation point (smallest element): " + rotationPoint);  // Output: 2
    }
}
