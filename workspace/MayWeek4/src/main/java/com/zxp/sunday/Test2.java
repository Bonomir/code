package com.zxp.sunday;

import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public List<List<Integer>> combine(int n, int k) {
        // 结果集合
        List<List<Integer>> result = new LinkedList<>();
        // 当前组合
        LinkedList<Integer> combination = new LinkedList<>();
        // 回溯计算
        backtrack(n, k, 1, combination, result);
        return result;
    }

    private void backtrack(int n, int k, int index, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new LinkedList<>(combination));
        } else if (index <= n) {
            backtrack(n, k, index + 1, combination, result);
            combination.add(index);
            backtrack(n, k, index + 1, combination, result);
            combination.removeLast();
        }
    }
}
