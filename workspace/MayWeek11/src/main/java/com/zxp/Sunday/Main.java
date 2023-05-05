package com.zxp.Sunday;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 输入一组数据
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        // 求众数
        Map<Integer, Integer> map = new HashMap<>();
        // 统计每个出现的次数
        for (Integer integer : list) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        // 找到最大的max
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (max < value) {
                max = value;
            }
        }
        // 众数数组
        List<Integer> list1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list1.add(entry.getKey());
            }
        }
        // 查找中位数
        list1.sort(((o1, o2) -> o1 - o2));
        int size = list1.size();
        if (size % 2 == 0) {
            int res = list1.get((size / 2 - 1)) + list1.get(size / 2);
            System.out.println(res);
        } else {
            System.out.println(list1.get(size / 2));
        }
    }
}
