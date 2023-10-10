package com.huaizhu;

import java.util.LinkedList;
import java.util.Queue;

public class 判断一棵树是否是完全二叉树 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int _value){
            value = _value;
        }
    }

    public static boolean isCBT(Node head){
        if(head == null){
            return false;
        }
        //是否遇到过不全的节点
        boolean leof = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            Node l = node.left;
            Node r = node.right;

            //1.左节点为null 右节点 不为null
            //2.当遇到左右不全的节点时，剩下的节点必须时叶节点
            if (
                    (l == null && r != null)
                            ||
                            (leof && (l != null || r != null))
            ) {
                return false;
            }

            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }

            if(l == null || r == null){
                leof = true;
            }
        }
        return true;

    }
}
