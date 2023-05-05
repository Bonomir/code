package com.zxp.Monday;

/**
 * 二叉树 ： 维护前缀和
 */
public class Solution {
    private int[] tree;
    private int[] nums;

    public Solution(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;
        // 将元素添加到二叉搜索树中
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    private int lowBit(int x) {
        return x & -x;
    }

    public void update(int index, int val) {
        add(index + 1,val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0){
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }
}
