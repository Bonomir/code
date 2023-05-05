package com.zxp.thursday;

public class Test {

    public static int[] sortArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 第一轮循环找到最大值和最小值
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 统计每个数字出现的次数
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int i = 0;
        for (int num = min; min <= max;num++){
            while (counts[num-min] > 0){
                nums[i++] = num;
                counts[num-min]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
