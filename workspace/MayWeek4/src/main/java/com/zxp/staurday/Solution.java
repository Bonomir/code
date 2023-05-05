package com.zxp.staurday;

public class Solution {
    public String removeOuterParentheses(String s) {
        // 找出原语化的字符串
        int left = 0;
        int right = 0;
        int head = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (right != 0 && left == right) {
                // [head,i)
                String substring = s.substring(head + 1, i - 1);
                res.append(substring);
                head = i;
                left = 0;
                right = 0;
            }
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
        }
        return res.toString();
    }
}
