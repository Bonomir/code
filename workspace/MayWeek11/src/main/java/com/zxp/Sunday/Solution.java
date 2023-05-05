package com.zxp.Sunday;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Integer> findDuplicatesTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当前遍历到达数字 和 应该放置的位置数字是否相同
            // 如果相同，就放置在这里不动，如果不相同，把他放置在应该放置的位置上 数字i放置在下标i-1处
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] > 0) {
                nums[idx - 1] = -nums[idx - 1];
            }else {
                list.add(idx);
            }
        }
        return list;
    }
}
