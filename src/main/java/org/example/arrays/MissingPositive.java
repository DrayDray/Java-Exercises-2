package org.example.arrays;

import java.util.Arrays;

public class MissingPositive {

    //Find first missing positive in an array
    public static void main(String[] args) {
        //unsorted
        int[] nums = new int[]{1,2,0};
        int solution = firstMissingPositive(nums);
        System.out.println("First Missing Positive:" + solution);
    }


    public static int firstMissingPositive(int[] nums){
        //default value
        int missing = 1;

        if(nums == null || nums.length == 0){
            return missing;
        }

        Arrays.sort(nums);
        for(int val: nums){
            if(val > 0){
                if(val == missing){
                    missing +=1;
                }
            }
        }

        return missing;
    }
}
