package com.zxp.sunday;

/**
 * 注意越界
 */
public class WeekCom {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < len; index = index +  k) {
                String de;
                if (index+k < len) {
                    de = decomposition(s, index, index + k);
                } else {
                    de = decomposition(s, index, len);
                }
                sb.append(de);
            }
            s = sb.toString();
        }
        return s;
    }

    // [start,end) 区间
    private String decomposition(String s, int start, int end) {
        // 计算出这个区间的和
        int sum = 0;
        String substring = s.substring(start, end);
        for (int i = 0; i < substring.length(); i++) {
            sum += substring.charAt(i) - '0';
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        String s = "475730385258137";
        int k = 13;
        WeekCom weekCom = new WeekCom();
        String s1 = weekCom.digitSum(s, k);
        System.out.println(s1);
    }
}
