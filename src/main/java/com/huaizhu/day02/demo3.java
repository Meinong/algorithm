package com.huaizhu.day02;


//实现队列
public class demo3 {

    public static class Node<V>{
        public Node<V> next;

        public V value;

        public Node(V v){
            value = v;
            next = null;
        }
    }

    public static class Queue<V>{
        public Node<V> head;

        public Node<V> tail;

        public int size;

        public Queue(){
            head = null;
            tail = null;
            size = 0;
        }


        //放入元素
        public void offer(V v){
            Node<V> node = new Node<>(v);
            if(tail == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

        //取元素
        public Node<V> poll(){
            Node<V> ans = null;
            if(head !=null){
                ans = head;
                head = head.next;
            }

            if(head == null){
                tail = head;
            }
            size--;
            return ans;
        }
    }
}
