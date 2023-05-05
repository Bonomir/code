package com.zxp.tuesday;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        String pre = "";
        for (String word : words){
            if (!check(pre,word,arr)){
                return false;
            }
            pre = word;
        }
        return true;
    }

    private boolean check(String s1,String s2,int[] order){
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2){
                // 字符不同，那就按照 order 的顺序排序即可
                return order[c1-'a'] - order[c2-'a'] <= 0;
            }
        }
        // 前缀相同，字符较短的排在前边
        return s1.length() <= s2.length();
    }
}
