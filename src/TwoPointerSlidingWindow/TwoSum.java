package TwoPointerSlidingWindow;

import java.util.Arrays;

/** *
 * Leetcode problem #1
 * Given sorted array of integers and a target. Find if sum of any two elements equals target. Here we use two
 * pointers from opposite directions with fixed speed
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left,right;
        left = 0;right = nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum == target) return new int[]{left,right};
            if(sum>target) right--;
            else left++;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{1,2,3,4,5,6,7,8,9,10},8))); // ans [0,6]
    }
}
