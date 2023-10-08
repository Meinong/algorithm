package com.huaizhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 多叉树采用二叉树序列化及反序列化 {

    /**
     * 一颗多叉树
     */
    public static class Node{
        public Integer val;
        public List<Node> children;

        public Node(Integer _val){
            val = _val;
        }
        public Node(Integer _val,List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    public static class TreeNode{
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer _val){
            val = _val;
        }
    }

    public static TreeNode encode(Node root){
        if(root == null){
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    public static TreeNode en(List<Node> children){
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child:children){
            TreeNode treeNode = new TreeNode(child.val);
            if(head == null){
                head = treeNode;
            }else{
                cur.right = treeNode;
            }
            cur = treeNode;
            cur.left = en(child.children);
        }
        return head;
    }

    public static Node decode(TreeNode root){
        if(root == null){
            return null;
        }
//        Node head = new Node(root.val);
//        head.children = de(root);
        return new Node(root.val,de(root));
    }

    public static List<Node> de(TreeNode root){
        List<Node> children = new ArrayList<>();
        while (root != null){
            Node cur = new Node(root.val,de(root.left));
            children.add(cur);
            root = root.right;
        }
        return children;
    }

}
