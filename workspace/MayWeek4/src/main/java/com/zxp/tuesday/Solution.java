package com.zxp.tuesday;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, 0);
    }

    public int helper(TreeNode root, int depth) {
        depth++;
        // 如果没有左子树和右子树说明是叶子节点，直接返回深度就行
        if (root.left == null && root.right == null) {
            return depth;
        }
        if (root.left == null){
            return helper(root.right, depth);
        }
        if (root.right == null){
            return helper(root.left, depth);
        }
        // 否则，总左右字数中找最小的深度即可
        int left = helper(root.left, depth);
        int right = helper(root.right, depth);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        root.right = node1;
        TreeNode node2 = new TreeNode(4);
        node1.right = node2;
        TreeNode node3 = new TreeNode(5);
        node2.right = node3;
        TreeNode node4 = new TreeNode(6);
        node3.right = node4;
        Solution solution = new Solution();
        int i = solution.minDepth(root);
        System.out.println(i);
    }
}
