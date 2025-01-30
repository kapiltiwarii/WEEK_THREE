    import java.util.HashMap;

    public class ZeroSumSubarrays {

        public static void findZeroSumSubarrays(int[] arr) {
            HashMap<Integer, Integer> cumulativeSumMap = new HashMap<>();
            int cumulativeSum = 0;

            // Add the initial cumulative sum (0) to the map
            cumulativeSumMap.put(0, -1);  // This helps in identifying subarrays starting from index 0

            for (int i = 0; i < arr.length; i++) {
                cumulativeSum += arr[i];

                // If cumulative sum has appeared before, it means there is a zero sum subarray
                if (cumulativeSumMap.containsKey(cumulativeSum)) {
                    // We found a subarray from the previous occurrence of this cumulative sum to the current index
                    int startIndex = cumulativeSumMap.get(cumulativeSum) + 1;
                    // Print the subarray
                    System.out.print("Subarray with zero sum: ");
                    for (int j = startIndex; j <= i; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }


                // Put the current cumulative sum with its index in the map
                cumulativeSumMap.put(cumulativeSum, i);
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, -1, 2, -2, 3, -3, 4, -4,2,3,-5};
            findZeroSumSubarrays(arr);
        }
    }


