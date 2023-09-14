package com.huaizhu;

public class 判断两棵二叉树结构一致 {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null ^ q == null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
