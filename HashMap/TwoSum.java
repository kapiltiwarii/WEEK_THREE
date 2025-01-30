import java.util.HashMap;

public class TwoSum {
    public static void hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int count = 0;
        int ansArr[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists in HashMap
            if (numMap.containsKey(complement)) {
                ansArr[0] = numMap.get(complement);
                ansArr[1] = i;
                System.out.print("[" + ansArr[0] + " " + ansArr[1] + "]");
                count++;
            }

            // Store current number in HashMap
            numMap.put(arr[i], i);
        }

        if (count == 0) {
            System.out.println("not found");
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, 5, 8, 4};
        int target = 9;
        hasPairWithSum(arr, target);
    }
}
