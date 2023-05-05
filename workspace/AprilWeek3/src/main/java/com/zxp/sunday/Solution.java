package com.zxp.sunday;

import java.util.*;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        String[] splits = paragraph.toLowerCase().split("[ ,\\.!?:;']");
        String word = null;
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (String split : splits) {
            // 是否包含在禁用列表中，并且不是空格，就统计
            if (!ban.contains(split) && split.length() > 0) {
                map.put(split, map.getOrDefault(split, 0) + 1);
                if (map.get(split) > max) {
                    max = map.get(split);
                    word = split;
                }
            }
        }
        return word;
    }

    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = new String[]{"bob", "hit"};
        String s = new Solution().mostCommonWord(paragraph, banned);
        System.out.println("s: " + s);
    }


}
