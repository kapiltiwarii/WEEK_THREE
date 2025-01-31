import java.util.Arrays;

public class SortExamScores {
    private static void sorScores(int[] scores) {
        int size = scores.length;

        for (int i = 0; i < size; i++) {
            int min_index=i;
            for (int j = i+1; j < size; j++) {
                if (scores[min_index]>scores[j]){
                    min_index = j;
                }
            }
            int temp = scores[min_index];
            scores[min_index]=scores[i];
            scores[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70,50,33,95,40,80,25};
        sorScores(scores);
        System.out.println(Arrays.toString(scores));
    }
}
