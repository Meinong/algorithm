package com.huaizhu;

/**
 * 条件｜左数高度-右数高度｜ <= 1
 */
public class 判断一棵树是平衡二叉树 {


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean i,int h){
            isBalanced = i;
            height = h;
        }
    }
    public static Info process(TreeNode x){
        if(x == null){
            return new Info(true,0);
        }
        Info left = process(x.left);
        Info right = process(x.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height-right.height) < 2;

        return new Info(isBalanced,height);
    }

    public static boolean isBalanced(TreeNode root){
        return process(root).isBalanced;
    }
}
