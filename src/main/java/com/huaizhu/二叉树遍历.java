package com.huaizhu;

import java.util.Stack;

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

    //先序非递归方式
    //1.创建一个栈
    //2.先将头节点押入 之后弹出，弹出时有右孩子先压右，有右再压左
    //3.之后弹出重复2的动作
    public static void pre1(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
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
    //中序非递归
    //解题思路：先遍历左树，出来时放入右孩子
    public static void in1(Node head){
        if(head !=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    head = head.right;
                }
            }
        }
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

    //后序遍历非递归
    //解体思路： 先压站先 头左右 再出站之后压另一个站 头 右 左 最后再出站 --> 左 右 头
}
