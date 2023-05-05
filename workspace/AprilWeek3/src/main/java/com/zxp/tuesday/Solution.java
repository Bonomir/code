package com.zxp.tuesday;

import java.util.Arrays;
/*
    字符S 的长度[1, 1000] 的范围。
    S 只包含小写字母。
    widths 是长度为26的数组。
    widths[i]值的范围在[2, 10]。
 */
public class Solution {

    // 最大宽度
    public static final int MAX_WIDTH = 100;

    // 求多少行可以放下，以及最后一行的字母有多少个
    public int[] numberOfLines(int[] widths, String s) {
        // 用来记录行数
        int lines = 0;
        // 记录最后一行的字母有多少个
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            // 求出当前字符所占用位置
            int need = widths[s.charAt(i) - 'a'];
            // 最后一行的字符数 = 上一行 width + need
            width += need;
            // 如果最后一行的字符数量大于最大宽度，换行，注意换行后的不会超过最大宽度 宽度范围为[2,10]
            while (width > MAX_WIDTH){
                lines++;
                width = need;
            }
        }
        return new int[]{lines+1,width};
    }


    public static void main(String[] args) {
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(new Solution().numberOfLines(widths, s)));
    }
}
