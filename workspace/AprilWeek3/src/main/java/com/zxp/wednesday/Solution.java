package com.zxp.wednesday;

/**
 * 面试题34：外星语言是否排序
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // 用哈希表计算每个字母的位置
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        // 判断字符数组是否排序
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i],words[i+1],orderArray)){
                return false;
            }
        }
        return true;
    }

    // 判断相邻两个单词是否按照字母表排序
    private boolean isSorted(String word1, String word2, int[] order) {
        int index = 0;
        while (index < word1.length() && index < word2.length()){
            char ch1 = word1.charAt(index);
            char ch2 = word2.charAt(index);
            // 如果两个字母一样就需要，比较下一个字母
            // 如果 ch1 > ch2 false
            // 如果 ch1 < ch2 true
            if (order[ch1 - 'a'] > order[ch2 - 'a']) {
                return false;
            }
            if (order[ch1 - 'a'] < order[ch2 - 'a']){
                return true;
            }
            index++;
        }
        return index == word1.length();
    }
}
