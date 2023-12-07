package main.java.org.example.arrays;


import java.util.Arrays;

/**
 * Rotate array k spots to the right
 */
public class RotateArray {

    public static final int INCREMENT = 2;
    public static final int[] ARRAY1 = {0, 10, 20, 30, 40, 50, 60};
    public static final int[] ARRAY2 = {0, 10, 20, 30, 40, 50, 60};
    public static void main(String[] args) {

        int[] array = {0, 1, 2, 3, 4, 5, 6};
        //easy version -using extra space
        rotateEasy(array, INCREMENT);
        System.out.println("Extra space algorithm:");
        System.out.println(Arrays.toString(array));


        int[] array2 = {0, 10, 20, 30, 40, 50, 60};
        rotateInPlace(array2, INCREMENT);
        System.out.println("O(1) space algorithm:");
        System.out.println(Arrays.toString(array2));
    }

    /*
    Could you do it in-place with O(1) extra space?
     */
    public static void rotateInPlace(int[] arr, int increment) {
        for (int i = 0; i < increment; i++) {
            moveValue(i, i, i + increment, arr[i], arr, increment);
        }
    }

    //recursive
    public static void moveValue(int startingIndex, int li, int ri, int shiftingValue, int[] arr, int increment) {
        if (ri >= arr.length) {
            //END CASE
            arr[startingIndex] = shiftingValue;
            return;
        }
        //store values
        int leftValue = arr[li];
        int rightValue = arr[ri];

        //override right value
        arr[ri] = shiftingValue;

        //right value is the value to increment
        moveValue(startingIndex, ri, ri + increment, rightValue, arr, increment);
    }

    public static void rotateEasy(int[] nums, int k) {

        //easiest solution
        int[] numsCopy = new int[nums.length];

        for (int i = 0; i < nums.length - k; i++) {
            numsCopy[i + k] = nums[i];
        }

        int gap = nums.length - k;
        for (int i = gap; i < nums.length; i++) {
            numsCopy[i - gap] = nums[i];
        }

        nums = numsCopy;
    }
}
