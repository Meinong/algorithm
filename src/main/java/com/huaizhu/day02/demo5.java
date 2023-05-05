package com.huaizhu.day02;


//双向链表 实现队列
public class demo5 {


    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node<V> last;

        public Node(V value){
            this.value = value;
            next = null;
            last = null;
        }
    }

    public static class Deque<V>{
        public Node<V> head;

        public Node<V> tail;

        public int size;

        public Deque(){
            size = 0;
            head = null;
            tail = null;
        }

        public void pushHead(V value){
            Node<V> cur = new Node<>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        public void pushTail(V value){
            Node<V> cur = new Node<>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size++;
        }


        public Node<V> headPoll(){
            Node<V> ans = null;
            if(head == null){
                tail = head;
                return ans;
            }
             ans = head;
             head = head.next;
             head.last = null;
             size--;
             return ans;
        }
    }
}
