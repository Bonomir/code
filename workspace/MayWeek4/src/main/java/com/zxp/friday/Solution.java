package com.zxp.friday;

public class Solution {
    public int findCloset(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }
}
