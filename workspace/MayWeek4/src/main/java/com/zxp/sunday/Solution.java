package com.zxp.sunday;

public class Solution {
    public String validIPAddress(String queryIP) {
        // 如果是 IPV4,返回字符串 IPV4
        if (isIPV4(queryIP)){
            return "IPV4";
        }
        // 如果是 IPV6,返回字符串 IPV6
        if (isIPV6(queryIP)){
            return "IPV6";
        }
        // 否则，返回 Neither
        return "Neither";
    }

    public boolean isIPV6(String queryIP) {
        // 如果不包含分割符号 . 就不是ipv6地址
        if (!queryIP.contains(":") || queryIP.endsWith(":") || queryIP.startsWith(".")){
            return false;
        }
        String[] split = queryIP.split(":");
        if (split.length != 8){
            return false;
        }
        // 满足：必须是数字，且开头不是0.
        // 数字范围 [0,255]
        for (String s : split) {
            // 每个字符串位数校验
            if (s.length() < 1 || s.length() > 4){
                return false;
            }
            // 查看是否为数字,小写英文字母和大写英文字母
            if (!s.matches("[a-f0-9A-F]{1,4}")) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPV4(String queryIP) {
        // 如果不包含分割符号 . 就不是ipv4地址
        if (!queryIP.contains(".") || queryIP.endsWith(".") || queryIP.startsWith(".")){
            return false;
        }
        String[] split = queryIP.split("\\.");
        if (split.length != 4){
            return false;
        }
        // 满足：必须是数字，且开头不是0.
        // 数字范围 [0,255]
        for (String s : split) {
            // 查看是否为数字
            if (!s.matches("[0-9]+")) {
                return false;
            }
            // // IPV4 不允许前导0
            if (s.startsWith("0") && s.length() != 1){
                return false;
            }
            // 判断数字是否在范围内
            if (s.length() > 4){
                // 如果字符串长度大于4,就说明比255肯定要大，避免整数溢出
                return false;
            }
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "00.0.0.0";
        System.out.println(solution.isIPV4(s));
    }
}
