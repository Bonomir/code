package com.zxp.saturday;

public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int count = getCharsNumber(widths, s);
        int line = count / 100 + 1;
        System.out.println(line);
        int lastLine = count % 100;
        System.out.println(lastLine);
        return new int[]{line, lastLine};
    }


    private int getCharsNumber(int[] arr, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 获取字符
            char ch = s.charAt(i);
            // 计算需要的位置
            count += arr[ch - 97];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        new Solution().numberOfLines(arr,s);
    }
}
