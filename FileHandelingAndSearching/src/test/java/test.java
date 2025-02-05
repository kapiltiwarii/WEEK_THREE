import org.example.ReverseStringUsingStringBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.BinarySearchFirstLast.findFirstAndLast;
import static org.example.LinearAndBinarySearch.binarySearch;
import static org.example.LinearAndBinarySearch.firstMissingPositive;
import static org.example.LinearSearchSentence.searchSentence;
import static org.example.PeakElement.findPeak;
import static org.example.RemoveDuplicatesfromString.removeDuplicateChars;
import static org.example.RotationPointFinder.findRotationPoint;
import static org.example.SearchFirstNegativeNumber.searchFirstNegativeNumber;
import static org.example.SearchIn2DArray.searchMatrix;
import static org.example.StringBufferConcatenation.concatenateStrings;


public class test {
    @Test
    void reverseString (){
        String str = "Hello";
       Assertions.assertEquals("olleH", ReverseStringUsingStringBuilder.reverseString(str));
    }


    @Test
    void removeDuplicate(){
        String str = "kaaapil";
        Assertions.assertEquals("kapil",removeDuplicateChars(str));
    }

    @Test
    void concatenation(){
        String[] words = {"Hello","Kalpesh","Welcome","to","Capgemini"};
        Assertions.assertEquals("HelloKalpeshWelcometoCapgemini",concatenateStrings( words));
    }

    @Test
    void SearchFirstNegative(){
        int arr[] = {2,3,4,-1,4,5,7,8,9,10};
        Assertions.assertEquals(3,searchFirstNegativeNumber(arr));
    }

    @Test
    void searchSentences() {
        String[] sentences = {
                "Hello capgemini team",
                "Here we are studying Java fullstack course",
                "Bridglabz is going to train us",
                "It is a very interesting Program"
        };
        String searchWord = "Java";

      Assertions.assertEquals("Here we are studying Java fullstack course",searchSentence(sentences,searchWord));
    }

    @Test
    void RotationPoint(){
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3};

        Assertions.assertEquals(2,findRotationPoint(rotatedArray));
    }

    @Test
    void peak(){
        int[] arr = {1, 3, 20, 4, 1, 0};

        Assertions.assertEquals(20,findPeak(arr));
    }

    @Test
    void serchIn2D(){
        // Example matrix
        int[][] matrix = {
                {1, 3, 5},
                {10, 12, 14},
                {20, 22, 24},
                {30, 35, 40}
        };
        int target = 22;
        Assertions.assertEquals(true,searchMatrix(matrix, target));
    }

    @Test
    void firstLast(){
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 6};
        int target = 2;

        int newArr[] = {1,3};

        Assertions.assertArrayEquals(newArr,findFirstAndLast(arr, target));
    }

    @Test
    void linearAndBinary(){
        int[] arr = {3, 4, -1, 1};
        int target = 4;
        Assertions.assertEquals(2,firstMissingPositive(arr));
        Assertions.assertEquals(3,binarySearch(arr,target));
    }
    }



