package com.huaizhu.day03;

public class demo2 {

    public static void main(String[] args) {
        //两个链表相加
        //1->2->3->4
        //+
        //2->3->4

        Node<Integer> n1 = new Node<>(9);
        n1.next = new Node<>(9);
        n1.next.next = new Node<>(9);
        n1.next.next.next = new Node<>(9);

        Node<Integer> n2 = new Node<>(9);
        n2.next = new Node<>(9);
        n2.next.next = new Node<>(9);
        n2.next.next.next = new Node<>(9);

        Node sum = sum(n1, n2);
        while (sum != null){
            System.out.printf(sum.value + " ");
            sum = sum.next;
        }

    }


    //两个链表相加
    //1->2->3->4
    //+
    //2->3->4

    public static Node sum(Node<Integer> n1,Node<Integer> n2){

        if(n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }

        //比较两个链表的长度 长的叫lNode 短的叫sNode
        Node<Integer> lNode = length(n1) > length(n2) ? n1 : n2;
        Node<Integer> sNode = lNode == n1 ? n2 : n1;
        Node<Integer> last = lNode;
        Node<Integer> ans = lNode;

        //定义一个进位
        int carry = 0;

        while (lNode !=null && sNode != null){
            last = lNode;
            int sum = lNode.value + sNode.value + carry;
            lNode.value = sum % 10 ;
            carry = sum / 10;
            lNode = lNode.next;
            sNode = sNode.next;
        }

        while (lNode !=null){
            last = lNode;
            int sum = lNode.value + carry;
            lNode.value = sum % 10 ;
            carry = sum / 10;
            lNode = lNode.next;
        }

        last.next = new Node<>(carry);
        return ans;
    }

    public static int length(Node n){
        int size = 0;
        while (n != null){
            size ++;
            n = n.next;
        }
        return size;
    }



    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V value){
            this.value = value;
            next = null;
        }
    }
}
