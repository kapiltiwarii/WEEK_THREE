import java.util.Arrays;
public class SortEmployeeId {
    private static void sortId(int[] id) {
       int size = id.length;

        for (int i = 1; i < size; i++) {
            int key = id[i];
            int j = i-1;

            while (j>=0 && id[j]>key){
                id[j+1]=id[j];
                j--;
            }
            id[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int[] id = {2,6,4,1,5,7};
        sortId(id);
        System.out.println(Arrays.toString(id));
    }
}
