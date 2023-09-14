package com.huaizhu;

/**
 * 先序： 头 左 右   -- 每一棵
 * 中序： 左 头 右   -- 每一棵
 * 后序： 左 右 头   -- 每一棵
 *
 */
public class 二叉树遍历 {

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    //先序
    public static void pre(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.val);
        pre(head.left);
        pre(head.right);
    }

    //中序
    public static void in(Node head){
        if(head == null){
            return;
        }
        in(head.left);
        System.out.println(head.val);
        in(head.right);
    }

    //后序
    public static void pos(Node head){
        if(head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.val);
    }
}
