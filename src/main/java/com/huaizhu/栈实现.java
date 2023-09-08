package com.huaizhu;

public class 栈实现 {

    static Node head = null;
    static int size = 0;


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        push(node1);
        push(node2);
        push(node3);
        push(node4);
//        while (head != null){
//            System.out.println(head.value);
//            head = head.next;
//        }

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    public static void push(Node node){
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public static Integer pop(){
        if(size == 0){
            return null;
        }
        int ans = head.value;
        head = head.next;
        size --;
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
}
