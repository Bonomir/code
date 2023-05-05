package com.zxp.saturday;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int N = nums.length / 2;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int repeated = entry.getValue();
            if (repeated == N){
                return entry.getKey();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,3};
        int i = solution.repeatedNTimes(nums);
        System.out.println(i);
    }
}
