package com.zxp.Sunday;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test2 {
    // 出现最多的次数
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        // key : 元素和 value ：出现次数
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        System.out.println(map.entrySet());
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
           if (map.get(key) == max){
               list.add(key);
           }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 求子树和 后序遍历
    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        // 如果树为空
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum,0) + 1);
        max = Math.max(max,map.get(sum));
        return sum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(14);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = null;
        node1.left = node2;
        int[] frequentTreeSum = new Test2().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(frequentTreeSum));
    }
}