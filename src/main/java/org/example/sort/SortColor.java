package main.java.org.example.sort;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class SortColor {

    public static void main(String[] args) {
        //int[] nums = new int[]{2,0,2,1,1,0};
        //int[] nums = new int[]{0,1};
        //int[] nums = new int[]{0,2,1};
        //int[] nums = new int[]{0,1,0};
        //int[] nums = new int[]{0,0};
        //int[] nums = new int[]{0,0,1};
        //int[] nums = new int[]{1,1,2,0,1,1,1,2};
        //int[] nums = new int[]{2, 1, 2, 0, 1, 1, 1, 1};
        //int[] nums = new int[]{0,0,1,0,1,1};
        int[] nums = new int[]{2,0,2,1,1,0};


        System.out.println("Before:" + Arrays.toString(nums));
        sortColors(nums);
        System.out.println("After:" + Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums.length != 1) {
            if(isComplete(nums)){
                return;
            }
            int color = 0;

            //figure out shiftToIndex
            int shiftToLeftIndex = getShiftToLeftIndex(nums, color);

            //all 0s; you're done
            if (shiftToLeftIndex == nums.length) {
                return;
            }

            //shift 0s leftwards
            for (int i = shiftToLeftIndex+1; i < nums.length; i++) {
                if(i == nums.length){
                    return;
                }
                if (nums[i] == color) {
                    //shift left
                    int temp = nums[shiftToLeftIndex];
                    nums[shiftToLeftIndex] = color;
                    nums[i] = temp;
                    shiftToLeftIndex++;
                }
            }

            //shift 2s rightwards
            color = 2;
            int shiftToRightIndex = getShiftToRightIndex(nums, color);
            for (int i = shiftToRightIndex - 1; i >= 0; i--) {
                if(i == nums.length){
                    return;
                }
                if (nums[i] == color) {
                    //shift right
                    int temp = nums[shiftToRightIndex];
                    nums[shiftToRightIndex] = color;
                    nums[i] = temp;
                    shiftToRightIndex--;
                }
            }
        }
    }

    private static boolean isComplete(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1] < nums[i]){
                return false;
            }
        }
        return true;
    }

    private static int getShiftToRightIndex(int[] nums, int color) {
        int shiftToIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == color) {
                shiftToIndex--;
            } else {
                break;
            }
        }
        return shiftToIndex;
    }

    private static int getShiftToLeftIndex(int[] nums, int color) {
        int shiftToIndex = 0;
        for (int i = color; i < nums.length; i++) {
            if (nums[i] == 0) {
                shiftToIndex++;
            } else {
                break;
            }
        }
        return shiftToIndex;
    }
}
