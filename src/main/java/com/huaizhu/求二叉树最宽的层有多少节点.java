package com.huaizhu;

import java.util.LinkedList;
import java.util.Queue;

public class 求二叉树最宽的层有多少节点 {

    public static class Node{
        public Integer val;
        public Node left;
        public Node right;
    }

    public static Integer getMaxNodes(Node root){
        Node curEnd = null ;
        Node nextEnd = null ;
        int curLevelNodes = 0;
        int maxNums = curLevelNodes;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        curEnd = root;
        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            curLevelNodes ++;
            if(curNode.left != null){
                queue.add(curNode.left);
                nextEnd = curNode.left;
            }
            if(curNode.right != null){
                queue.add(curNode.right);
                nextEnd = curNode.right;
            }
            if(curNode == curEnd){
                curEnd = nextEnd;
                nextEnd = null;
                maxNums = Math.max(curLevelNodes,maxNums);
                curLevelNodes = 0;
            }
        }
        return maxNums;
    }
}
