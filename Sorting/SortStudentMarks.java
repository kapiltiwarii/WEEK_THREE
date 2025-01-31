import java.util.Arrays;

public class SortStudentMarks {
    private static void sortMarks(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n; i++) {
          swapped=false;
            for (int j = 0; j <n-i-1 ; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }

    }
    public static void main(String[] args) {
        int marks[]={60,33,50,70,25};
        sortMarks(marks);
        System.out.println(Arrays.toString(marks));
    }
}
