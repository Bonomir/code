package com.zxp.tuesday;

import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution2 {

    public TreeNode findNext2(TreeNode root,TreeNode p){
        List<TreeNode> nodes = new LinkedList<>();
        dfs(root,nodes);
        int num = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(p)){
                if (i + 2 < nodes.size()){
                    return nodes.get(i+2);
                }
            }
        }
        return null;
    }

    private void dfs(TreeNode root, List<TreeNode> nodes) {
        if (root != null){
            nodes.add(root);
        }
        dfs(root.left,nodes);
        dfs(root.right,nodes);
    }
}
