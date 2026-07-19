package TwoPointerSlidingWindow;

import java.util.Arrays;

public class RemoveDuplicates {
    /**
     * leetcode #26
     * Removing duplicates from sorted arrays.
     * */
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[left])continue;
            left++;
            swap(nums,left,i);
        }

        return left+1;
    }
    private void swap(int[] arr,int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] nums;
//        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        nums = new int[]{1,2};
        System.out.println("Pre removal");
        System.out.println(Arrays.toString(nums));
        int idx = new RemoveDuplicates().removeDuplicates(nums);

        for(int i=0;i<idx;i++){
            System.out.print(nums[i]+",");
        }
    }
}
