package com.huaizhu.day02;


//实现栈
public class demo4 {


    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v){
            value = v;
            next = null;
        }
    }

    public static class Stock<V>{
        public Node<V> head;

        public int size;

        public Stock(){
            head = null;
            size = 0;
        }

        public void offer(V v){
            Node<V> node = new Node<V>(v);
            if(head == null){
                head = node;
            }else{
                node.next = head;
                head = node;
            }
            size ++;
        }

        public Node<V> poll(){
            Node<V> ans = null;
            if(head != null){
                ans = head;
                head = head.next;
                size --;
            }
            return ans;
        }
    }
}
