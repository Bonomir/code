package com.zxp.tuesday;

/**
 * 有效变位词
 * 例如：
 * abcde 和 cdeab
 */

public class Solution1 {

    public boolean isAnagram(String s, String t) {
        // 特殊条件控制
        if (s.length() != t.length()) {
            return false;
        }
        // 用数组模拟哈希表
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            // 如果当前字符在s中没有，直接返回false
            if (counts[c - 'a'] == 0){
                return false;
            }
            counts[c - 'a']--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().isAnagram("a", "a"));
    }
}
