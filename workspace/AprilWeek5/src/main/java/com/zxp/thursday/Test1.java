package com.zxp.thursday;

import java.util.Arrays;

public class Test1 {
    // 从小到大
    public static void bubbleSort(int[] arr) {
        // 外层排序为排序趟数 len 个元素需要len-1趟
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            // 内层循环为每一趟排序的次数
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) { // 如果前边一个大于后边的，就交换
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 7, 1};
        Test1.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
