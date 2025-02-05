package org.example;

public class SearchIn2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Convert mid to row and column
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
                {1, 3, 5},
                {10, 12, 14},
                {20, 22, 24},
                {30, 35, 40}
        };

        // Test case 1: target exists in the matrix
        int target1 = 22;
        System.out.println(searchMatrix(matrix, target1));  // Output: true

        // Test case 2: target does not exist in the matrix
        int target2 = 50;
        System.out.println(searchMatrix(matrix, target2));  // Output: false
    }
}
