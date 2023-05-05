package com.zxp.Sunday;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0){
            return result;
        }
        helper(nums,0,new LinkedList<Integer>(),result);
        return result;
    }

    private void helper(int[] nums,int index,LinkedList<Integer> subset,List<List<Integer>> result){
        if (index == nums.length){
            result.add(new LinkedList<>(subset));
        }else {
            // 不添加
            helper(nums,index+1,subset,result);
            // 添加
            subset.add(nums[index]);
            helper(nums,index+1,subset,result);
            subset.removeLast();
        }
    }
}
