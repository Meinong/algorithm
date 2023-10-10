package com.huaizhu;

/**
 * 如果一个树的高度为h ,那么这棵树一共右2的h次方-1
 */
public class 判断一棵树是否是满二叉树 {


    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int _value){
            value = _value;
        }
    }


    public static class Info{
        public int height; //高度
        public int nodes; //节点数

        public Info(int _height,int _nodes){
            height = _height;
            nodes = _nodes;
        }
    }


    public static Info process(Node head){
        if(head == null){
            return new Info(0,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);


        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height,nodes);
    }

    public static boolean isTrue(Node head){
        if(head == null){
            return true;
        }
        return (1<< process(head).height -1) == process(head).nodes;
    }
}
