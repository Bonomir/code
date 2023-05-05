package com.zxp.friday;

import java.util.Arrays;

public class Test {
    public static void quickSort(int[] array) {
        // 辅助完成递归过程，这里使用的闭区间
        quickSortHelper(array, 0, array.length - 1);
    }

    // 辅助函数 ： [left , right]
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 此时，区间有 0 或者 1 个元素，不用排序
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    /*
        partition 方法做：
            取出一个基准值，让小于基准值的放在基准值左边，大于基准值的放在右边
            并且返回基准值在这样一次调整中的位置
     */
    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        // 取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            // 从左往右找比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 从右往左找比基准值比基准值小的元素
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 执行完上面的步骤，beg 要么和end重合，要么end就指向一个小于base的值
            // 交换beg 和 end 的值
            swap(array, beg, end);
        }
        swap(array, beg, right);
        return beg;
    }

    private static void swap(int[] array, int beg, int end) {
        int tmp = array[beg];
        array[beg] = array[end];
        array[end] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 3, 7, 5, 8};
        Test.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
