package com.zxp.saturday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class weekGame {
    public int largestInteger(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        // 翻转列表
        Collections.reverse(list);
        boolean[] mark = new boolean[list.size()];
        // 偶数
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 奇数
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < list.size(); i++) {
            Integer temp = list.get(i);
            if (temp % 2 != 1){
                // 偶数
                mark[i] = true;
                queue1.add(temp);
            }else{
                mark[i] = false;
                queue2.add(temp);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (boolean b : mark) {
            Integer integer;
            if (b) {
                // 获取队头元素并删除
                integer = queue1.poll();
            } else {
                integer = queue2.poll();
            }
            builder.append(integer);
        }
        return Integer.parseInt(builder.toString());
    }


    public static void main(String[] args) {
        int num = 1234;
        System.out.println(new weekGame().largestInteger(num));
        int num1 = 65875;
        System.out.println(new weekGame().largestInteger(num1));
        int[] arr = new int[]{0,4};
        System.out.println(new weekGame().maximumProduct(arr, 5));
    }

    public int maximumProduct(int[] nums, int k) {
        nums[0]+=k;
        int res = 1;
        for (int num : nums) {
            res = (res * num) % ((int) Math.pow(10, 9) + 7);
        }
        return res;
    }

}
