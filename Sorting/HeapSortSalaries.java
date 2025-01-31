import java.util.Arrays;

public class HeapSortSalaries {

    // Function to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to the end
            swap(salaries, 0, i);

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to maintain the Max Heap property
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(salaries, i, largest);

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test Heap Sort
    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 60000, 90000, 40000, 75000};

        System.out.println("Original Salaries: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }
}
