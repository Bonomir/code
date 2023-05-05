package com.zxp.Sunday;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        String str = sc.next();
        int k = 2;
        String str = "aaa_password_\"a12_45678\"_timeout__100_\"\"_";
        System.out.println(str);
        // 加密
        String res = encrypt(k, str);
        System.out.println(res);
    }

    // 字符串由大小写英文，数字，下划线,""
    // 加密并且要删除命令字前后的下划线
    // 需要判断这个空
    private static String encrypt(int k, String str) {
        if (str == null || str.length() == 0) {
            return "ERROR";
        }
        // 删除多余下划线
        String substr = substr(str);
        System.out.println("子串");
        System.out.println(substr);
        List<String> l = toStringList(substr);
        System.out.println("l");
        System.out.println(l);
        if (k > l.size()) {
            return "ERROR";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i);
            if (k == i) {
                s = "******";
            }
            res.append(s);
            res.append("_");
        }
        // 删除最后一个下划线
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // 分割成字符串
    private static List<String> toStringList(String str) {
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int flag = 0; // 跳过标记,当为1的时候表明在一个双引号中，不处理下划线
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 遇见的不是下划线
            if (c != '_'){
                if (c == '"' && flag == 0){
                    flag = 1;
                }
                if (c == '"' && flag == 1){
                    flag = 0;
                }
                right++;
            }else {
                // 下划线处理
                if (flag == 1){
                    right++;
                }else {
                    String s;
                    if (left != 0) {
                        left++;
                        right++;
                    }
                    s = str.substring(left, right);
                    list.add(s);
                    left = right;
                }
            }
        }
        return list;
    }

    // 用来处理多余的下划线
    private static String substr(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.empty()) {
                stack.add(str.charAt(i));
            }
            Character peek = stack.peek();
            if (peek == '_' && str.charAt(i) == '_') {
                str = str.substring(0, i) + str.substring(i + 1);
            } else {
                stack.add(str.charAt(i));
            }
        }
        return str;
    }

}
