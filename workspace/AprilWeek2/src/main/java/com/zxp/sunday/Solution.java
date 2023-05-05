package com.zxp.sunday;

import java.util.HashSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String [] morseCodeTable =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.", "--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        // 转换为摩尔斯代码存放在HashSet上，HashSet多少就是结果
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String morseCodes = getMorseCodes(morseCodeTable,words[i]);
            set.add(morseCodes);
        }
        return set.size();
    }

    private String getMorseCodes(String[] morseCodeTable, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(morseCodeTable[word.charAt(i) - 'a']);
        }
        return sb.toString();
    }
}
