package com.zxp.Sunday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        // 测试用例
        // int k = 2;
        // String str = "aaa_password_\"a12_45678\"_timeout__100_\"\"_";
        // 获取其中单词
        List<String> words = findWords(str);
        System.out.println(words);
        // 对单词进行加密
        String res = encrypt(k, words);
        System.out.println(res);
    }

    private static List<String> findWords(String str) {
        int len = str.length();
        int left = 0;
        int right = 0;
        int flag = 0; // flag = 1，表示当前字符在""范围内
        List<String> list = new ArrayList<>();
        while (left < len && right < len){
            // 找左指针位置
            while (str.charAt(left) == '_'){
                left++;
            }
            right = left;
            // 找右指针位置
            while (right < len){
                // 遇到引号
                if (str.charAt(right) == '\"'){
                    if (flag == 0){
                        flag = 1;
                    }else {
                        flag = 0;
                    }
                    right++;
                    // 遇到不在引号中的下划线
                } else if (str.charAt(right) == '_' && flag == 0){
                    // [left,right)  right所在字符不需要
                    String word = str.substring(left, right);
                    if (!word.equals("")){
                        list.add(word);
                    }
                    right++;
                    left = right;
                }else {
                    // 遇到字母，数字，引号内的下划线
                    right++;
                }
            }
        }
        return list;
    }


    // 字符串由大小写英文，数字，下划线,""
    // 加密并且要删除命令字前后的下划线
    private static String encrypt(int k, List<String> words) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i == k){
                res.append("******");
            }else {
                res.append(words.get(i));
            }
            if (i != words.size() -1){
                res.append("_");
            }
        }
        return res.toString();
    }
}
