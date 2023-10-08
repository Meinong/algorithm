package com.huaizhu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用一个队列
 */
public class 二叉树按层遍历 {
    public static class Node{
        public Integer val;
        public Node left;
        public Node right;
    }


    public static void level(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
}
