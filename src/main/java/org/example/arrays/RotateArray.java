package main.java.org.example.arrays;


import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        rotate(array, 3);

    }
    public static void rotate(int[] nums, int k) {

        //easiest solution
        int[] numsCopy = new int[nums.length];

        for(int i = 0; i < nums.length-k; i++){
            numsCopy[i+k] = nums[i];
        }

        int gap = nums.length - k;
        for(int i = gap; i < nums.length ;i++){
            numsCopy[i-gap] = nums[i];
        }

        nums = numsCopy;
        System.out.println(Arrays.toString(nums));

    }
}
