package com.zxp.friday;

import java.util.Arrays;

public class Solution {

//    public static List<StudentScoreDO> get25(List<StudentScoreDO> studentScoreDOS) {
//
//    }


    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        // 区间中有一个或者零个元素，不用排序
        if (start >= end) {
            return;
        }
        // 调用分组方法
        int index = partition(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
        int right = end;
        // 取最后一个元素为基准值
        int base = arr[end];
        while (start < end) {
            // 从左往右找比基准值大的元素
            while (start < end && arr[start] <= base) {
                start++;
            }
            // 从右往左找比基准值小的元素
            while (start < end && arr[end] >= base) {
                end--;
            }
            swap(arr, start, end);
        }
        // 调整基准值的位置，把它和修改后的end值交换位置
        swap(arr, start,right);
        return start;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 3, 7, 5, 8};
        Solution solution = new Solution();
        solution.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
