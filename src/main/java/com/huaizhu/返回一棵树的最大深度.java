package com.huaizhu;

public class 返回一棵树的最大深度 {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}
