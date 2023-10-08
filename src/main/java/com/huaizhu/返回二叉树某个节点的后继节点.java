package com.huaizhu;


/**
 * 后继节点，可以理解成，中序遍历后数组 ，每个元素的下一个数据
 */
public class 返回二叉树某个节点的后继节点 {

    public static class Node {
        public int val;

        public Node left;
        public Node right;
        public Node parent;
    }

    //方式1:先中序遍历
    //方式2:

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }

        //1.有右子树
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            //无右子树
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;

    }


}
