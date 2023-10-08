package com.huaizhu;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树序列化及反序列化 {

    public static class Node{
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer val){
            this.val = val;
        }
    }

    /**
     * 采用先序遍历的方式序列化
     * 注意：中序无法序列化，因为存在歧义
     *
     *        1
     *       /
     *      2
     *      和
     *      2
     *       \
     *        1
     *        中序都是一样的
     *        [null,2,null,1,null] [null,2,null,1,null]
     *
     */
    public static Queue<String> preSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        pres(head,ans);
        return ans;
    }

    public static void pres(Node head,Queue<String> ans){
        if(head ==null){
            ans.add(null);
        }else{
            ans.add(String.valueOf(head.val));
            pres(head.left,ans);
            pres(head.right,ans);
        }
    }

    /**
     * 采用先序遍历的方式反序列化
     */
    public static Node buildByPreQueue(Queue<String> ans){
        if(ans == null || ans.size() == 0){
            return null;
        }
        return preUnSerial(ans);
    }
    public static Node preUnSerial(Queue<String> ans){
        String val = ans.poll();
        if(val == null){
            return null;
        }
        Node head = new Node(Integer.valueOf(val));
        head.left = preUnSerial(ans);
        head.right = preUnSerial(ans);
        return head;
    }



    /*============================================================*/
    /**
     * 按层序列化
     */
    public static Queue<String> levelSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        if(head == null){
            ans.add(null);
        }else{
            Queue<Node> queue = new LinkedList<>();
            ans.add(String.valueOf(head.val));
            queue.add(head);
            while (!queue.isEmpty()){
                Node cur = queue.poll();
                if(cur.left != null){
                    ans.add(String.valueOf(cur.left.val));
                    queue.add(cur.left);
                }else{
                    ans.add(null);
                }
                if(cur.right != null){
                    ans.add(String.valueOf(cur.right.val));
                    queue.add(cur.right);
                }else{
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    /**
     * 按层 反序列化
     * @param ans
     * @return
     */
    public static Node buildByLevelUnSerial(Queue<String> ans){
        if(ans ==null || ans.size() == 0){
            return null;
        }
        Node head = buildNode(ans.poll());
        Queue<Node> queue = new LinkedList<>();
        if(head != null){
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = buildNode(ans.poll());
            node.right = buildNode(ans.poll());
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }

    public static Node buildNode(String val){
        if(val == null){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }





}
