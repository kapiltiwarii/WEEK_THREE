import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Boolean> numMap = new HashMap<>();
        int maxLength = 0;

        // Step 1: Store numbers in the HashMap using a normal for loop
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], false);  // Mark each number as unprocessed
        }

        // Step 2: Iterate through the array using a normal for loop
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // If num - 1 doesn't exist, then num is the start of a sequence
            if (!numMap.containsKey(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count the length of the consecutive sequence
                while (numMap.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update maxLength if we find a longer sequence
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(arr));
    }
}
