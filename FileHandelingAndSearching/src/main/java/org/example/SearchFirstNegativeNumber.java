package org.example;

public class SearchFirstNegativeNumber {
    // Method to search first negative number
    public static int searchFirstNegativeNumber(int[] arr) {
        // loop to iterate in array
        for (int i = 0; i < arr.length; i++) {
           if (arr[i]<0){ // condition to get negative number
               return i;
           }
        }
        return -1; // if negative number not found return -1
    }
    // Main method
    public static void main(String[] args) {
        int arr[] = {2,3,4,-1,4,5,7,8,9,10};

       int index = searchFirstNegativeNumber(arr);

        System.out.println("Index of first negative number is in index "+ index);
    }
}
