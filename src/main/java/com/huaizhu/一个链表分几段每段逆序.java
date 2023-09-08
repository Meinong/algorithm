package com.huaizhu;


/**
 * 1-2->3 ->4->5->6 ->7->8->9  ->0->1
 * ==>
 * 3->2->1  ->6->5->4-> 9->8->7 ->0->1
 *
 */
public class 一个链表分几段每段逆序 {

    public static void main(String[] args) {



    }

    public static Node returnRes(Node node){
        Node head = node;
        Node start = getEndByNum(node,3);
        Node ans = start;
        if(head == null){
            return node;
        }
        Node end = reserve(start,head);
        if(end == null){
            return ans;
        }
        while (start != null){
            start = getEndByNum(end,3);
            if(start == null){
                break;
            }
            head.next = start;
            head = end;
            end = reserve(start,end);
            if(end == null){
                break;
            }
        }
        return ans;
    }



    public static class Node{
        public int value;
        public Node next;


        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node getEndByNum(Node start,int k){
        while (--k > 0 && start != null){
            start = start.next;
        }
        return start;
    }

    public static Node reserve(Node start,Node head){
        Node end  = start.next;
        Node last = head;
        Node next = null;
        Node pre = null;
        while (head != end){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        last.next = end;
        return end;
    }

}
