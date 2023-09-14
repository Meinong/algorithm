package com.huaizhu;

public class 判断一棵树的某条路径和等于某个值 {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        isSum = false;
        process(root,0,sum);
        return isSum;
    }


    public static void process(TreeNode root,int preSum,int targetSum){
        if(root.left == null && root.right == null){
            if(preSum + root.val == targetSum){
                isSum = true;
            }
            return;
        }
        preSum += root.val;
        if(root.left != null){
            process(root.left,preSum,targetSum);
        }
        if(root.right != null){
            process(root.right,preSum,targetSum);
        }
    }



}
