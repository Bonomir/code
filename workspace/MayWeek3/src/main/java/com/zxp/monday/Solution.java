package com.zxp.monday;


import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){

        }
        return null;
    }
}
