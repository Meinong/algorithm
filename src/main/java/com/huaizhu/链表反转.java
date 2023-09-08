package com.huaizhu;

/**
 * 1->2->3
 * ==>3->2->1
 */
public class 链表反转 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        Node head = reverse(node);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static Node reverse(Node node){
        Node head = node;
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
