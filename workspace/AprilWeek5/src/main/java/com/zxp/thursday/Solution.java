package com.zxp.thursday;

import java.util.Arrays;

public class Solution {
    // [前边偶数，后边奇数]
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            // 如果是偶数
            while (left < right && nums[left] % 2 == 0){
                left++;
            }
            // 如果是奇数
            while (left < right && nums[right] % 2 != 0){
                right--;
            }
            swap(nums,left,right);
        }
        return nums;
    }

    public void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(nums)));
    }
}
