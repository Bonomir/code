package com.zxp.Tursday;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.Stack;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int row = strs.length;
        int col = strs[0].length();
        for (int i = 0; i < col; i++) { // 列数
            for (int j = 1; j < row; j++) { // 行数
                if (strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return  count;
    }
}
