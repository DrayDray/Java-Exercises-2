package main.java.org.example.sort;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Implementing Count Sort Algorithm
 */
public class CountSort {


    public static void main(String[] args) {
        int[] inputArray = {4, 3, 2, 1, 5, 5, 3, 2};
        System.out.print("Before sort:");
        System.out.println(Arrays.toString(inputArray));

        int[] outputArray = countSort(inputArray);

        System.out.print("After sort:");
        System.out.println(Arrays.toString(outputArray));
    }

    public static int[] countSort(int[] inputArray) {
        //find max input value
        OptionalInt maxOptional = Arrays.stream(inputArray).max();
        int max = maxOptional.getAsInt();

        int[] countArray = new int[max + 1];

        //fill in count array
        for (int i = 0; i < inputArray.length; i++) {
            int value = inputArray[i];
            countArray[value] = countArray[value]+1;
        }

        //make count array a cumulative count array
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        //fill in sorted array
        int[] sortedArray = new int[inputArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            int value = inputArray[i];
            int valueCount = countArray[value];
            if(valueCount >=1){
                //fill in value at correct position
                sortedArray[valueCount - 1] = value;
                //reduce index for value
                countArray[value]--;
            }
        }

        return sortedArray;
    }
}

