package com.zxp.Monday;

// 方法一 ： 分块处理
public class NumArray {
    private int[] sum;     // sum[i] 表示第 i 个块的元素和
    private int size;       // 块的大小
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n + size - 1) / size]; // n / size 向上取整，没懂
        for (int i = 0; i < n; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        // 计算元素在那个块 index / size
        int b1 = left / size, b2 = right / size;
        // 计算元素在块中的位置 index % size
        int i1 = left % size, i2 = right % size;
        // [b1,b2] 在同一个块中,直接计算，注意是闭区间
        if (b1 == b2) {
            int sum = 0;
            for (int index = i1; index <= i2; index++) {
                // b1 * size + index : b1 * size : 找到块元素0的下标，+index:找到块中第index个元素
                sum += nums[b1 * size + index];
            }
            return sum;
        }
        // 如果不在同一个块中
        // 先计算b1 元素块中 [i1,size-1] 的大小
        int sum1 = 0;
        for (int index = i1; index < size; index++) {
            sum1 += nums[b1 * size + index];
        }
        // 然后计算b2元素块中 [0,i2] 的大小
        int sum2 = 0;
        for (int index = 0; index <= i2; index++) {
            sum2 += nums[b2 * size + index];
        }
        // 最后计算b1-b2块之间的元素和
        int sum3 = 0;
        for (int index = b1 + 1; index < b2; index++) {
            sum3 += sum[index];
        }
        return sum1 + sum2 + sum3;
    }
}
