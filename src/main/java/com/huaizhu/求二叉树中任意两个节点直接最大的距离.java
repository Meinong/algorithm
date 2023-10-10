package com.huaizhu;

public class 求二叉树中任意两个节点直接最大的距离 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int _maxDistance,int _height){
            maxDistance = _maxDistance;
            height = _height;
        }
    }

    public static Info process(Node head){
        if(head == null){
            return new Info(0,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) +1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1,p2),p3);
        return new Info(maxDistance,height);
    }

    public static int test(Node head){
        return process(head).maxDistance;
    }
}
