package com.huaizhu;

/**
 * 9->9->9
 * 1
 */
public class 两个链表相加 {

    public static void main(String[] args) {

        Node node1 = new Node(9);
        node1.next = new Node(9);
        node1.next.next = new Node(9);
        node1.next.next.next = new Node(9);

        Node node2 = new Node(1);

        Node head = add(node1, node2);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }

    }

    public static Node add(Node node1,Node node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }

        Node lNode = getNodeSize(node1) > getNodeSize(node2) ? node1 : node2;
        Node sNode = lNode == node1 ? node2 : node1;
        //近位
        Node head = lNode;
        int carry = 0;
        Node last = null;
        //如果lnode 和 sNode 都存在时
        while(sNode != null){
            int num = (lNode.value + sNode.value + carry) % 10;
            carry = (lNode.value  + sNode.value + carry) / 10;
            last = lNode;
            lNode.value = num;
            lNode = lNode.next;
            sNode = sNode.next;
        }

        //sNode 不存在时
        while (lNode != null){
            int num = (lNode.value  + carry) % 10;
            carry = (lNode.value  + carry) / 10;
            last = lNode;
            lNode.value = num;
            lNode = lNode.next;
        }

        if(carry > 0){
            last.next = new Node(carry);
        }
        return head;
    }


    public static int getNodeSize(Node node){
        int size = 0;
        while (node != null){
            size ++;
            node = node.next;
        }
        return size;
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
