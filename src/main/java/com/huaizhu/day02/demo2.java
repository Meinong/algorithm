package com.huaizhu.day02;

public class demo2 {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1 = f(n1);
        while (n1 != null){
            System.out.println(n1.value +"");
            n1 = n1.next;
        }
    }

    //单链表逆序 1->2->3->null
    //null<-1 <-2 <-3
    public static Node f(Node head){
       Node next = null;
       Node pre = null;

       while (head !=null){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
       }
       return pre;
    }



    //单链表
    public static class Node{
        public int value ;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static class DoubleNode{
        public int value;

        public DoubleNode last;

        public DoubleNode next;
    }

    //双链表 逆序
    public static DoubleNode f2(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
