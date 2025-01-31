import java.util.Arrays;

public class QuickSortProducts {

    // Function to perform Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Function to partition the array
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }

        // Place pivot at the correct position
        swap(prices, i + 1, high);
        return i + 1;
    }

    // Function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test Quick Sort
    public static void main(String[] args) {
        int[] productPrices = {399, 150, 200, 99, 450, 300};

        System.out.println("Original Prices: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Prices: " + Arrays.toString(productPrices));
    }
}
