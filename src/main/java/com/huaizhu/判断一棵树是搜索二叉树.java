package com.huaizhu;

/**
 * 左子树比我小 右子树比我大
 */
public class 判断一棵树是搜索二叉树 {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    //1.中序遍历 如果都是有序的 从小到大 --> 搜索二叉树
    //2.递归


    public static class Info{
        public boolean isBST; //是否是搜索二叉树
        public int max;

        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(TreeNode root){
        if(root == null){
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int max = root.val;
        int min = root.val;
        if(leftInfo != null){
            max = Math.max(leftInfo.max, max);
        }
        if(rightInfo != null){
            min = Math.min(rightInfo.min, min);
        }

        boolean isBST = true;
        if(leftInfo != null && !leftInfo.isBST){
            isBST = false;
        }
        if(rightInfo != null && !rightInfo.isBST){
            isBST = false;
        }

        boolean leftMaxLessRoot = leftInfo == null || (leftInfo.max < root.val);
        boolean rightMinMoreRoot = rightInfo == null || (rightInfo.min > root.val);

        if(!leftMaxLessRoot || !rightMinMoreRoot){
            isBST = false;
        }
        return new Info(isBST,max,min);
    }
}
