package com.huaizhu.day03;

//一个链表 分 几段 每段逆序
public class demo1 {


    public static void main(String[] args) {
        //1->2->3->4->5->6->7->8->null
        //k = 3
        //3->2->1->6->5->4->7->8

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Node ans = returnRes(n1);
        while (ans != null){
            System.out.print(ans.value + " ");
            ans = ans.next;
        }
    }


    public static Node returnRes(Node n1){
        Node start = n1;
        Node head = getEndByNum(n1, 3);
        Node l1 = head;
        if(head == null){
            return n1;
        }
        Node end = reserve(head, n1);
        if(end == null){
            return head;
        }

        while (head != null){
            head = getEndByNum(end, 3);
            if(head == null){
                break;
            }
            start.next = head;
            start = end;
            end = reserve(head, end);
            if(end == null){
                break;
            }
        }
        return l1;
    }



    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v){
            value = v;
            next = null;
        }
    }

    //根据k 获取 k数量的最后一个
    //1->2->3->4->5->6->7->8->null
    //k=3 ===> 第一次获取3 第二次获取6 第三次获取null
    public static Node getEndByNum(Node start,int k){
        while (--k >0 && start != null ){
            start = start.next;
        }
        return start;
    }

    //逆序
    public static Node reserve(Node start,Node head){
        Node end = start.next;
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
