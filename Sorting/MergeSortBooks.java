import java.util.Arrays;

public class MergeSortBooks {

    // Function to perform Merge Sort
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort both halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays
    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);

        // Merge the arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k++] = leftArray[i++];
            } else {
                prices[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements if any
        while (i < n1) {
            prices[k++] = leftArray[i++];
        }

        while (j < n2) {
            prices[k++] = rightArray[j++];
        }
    }

    // Main function to test Merge Sort
    public static void main(String[] args) {
        int[] bookPrices = {399, 150, 200, 99, 450, 300};

        System.out.println("Original Prices: " + Arrays.toString(bookPrices));

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Prices: " + Arrays.toString(bookPrices));
    }
}
