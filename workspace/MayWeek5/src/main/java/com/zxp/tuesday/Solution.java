package com.zxp.tuesday;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index = 0;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,index,path,res,target, target);
        return res.stream().distinct().collect(Collectors.toList());
    }
    public static void dfs(int [] input,int index,Deque<Integer> path,List<List<Integer>> res,int target,int sum){
        if (index > sum){
            if (target == 0){
                List<Integer> list = path.stream().sorted().collect(Collectors.toList());
                res.add(list);
            }
            return;
        }
        dfs(input,index+1,path,res,target,sum);
        for (int j : input) {
            if (j > target) break;
            path.addLast(j);
            dfs(input, index + 1, path, res, target - j, sum);
            path.pollLast();
        }
    }


    public static void main(String[] args) {
        // int[] nums = {2,7,6,3,5,1};
        int[] nums = {2,1};
        List<List<Integer>> lists = combinationSum(nums, 2);
        System.out.println(lists);
    }
}
