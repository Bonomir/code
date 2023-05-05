package com.zxp.Friday;

public class solution {
    /**
     * 双指针：
     *  两个数字不同的时候：可能的情况
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();
        if (Math.abs(n-m) > 1){
            return false;
        }
        if (n > m){
            return oneEditAway(second,first);
        }
        int i = 0;  // first 下标
        int j = 0;  // second 下标
        int cnt = 0; // 是否已经跳过一次
        while (i < n && j < m && cnt <= 1){
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1==c2){
                i++;
                j++;
            }else {
                // 此时进行的是替换操作，first和second均跳过这个不同的
                if (n == m){
                    i++;
                    j++;
                    cnt++;
                }else { // 此时进行的是添加操作
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }

}
