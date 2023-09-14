package com.huaizhu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class n个有序链表合并 {

    public static class ListNode{
        public int val;

        public ListNode next;


    }

    public static class IdComparator implements Comparator<ListNode>{

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    }

    public static ListNode merge(ListNode[] listNodes){
        if(listNodes == null){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new IdComparator());
        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }
        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        if(pre.next != null){
            priorityQueue.add(pre.next);
        }
        while (!priorityQueue.isEmpty()){
            ListNode cur = priorityQueue.poll();
            pre.next =cur;
            pre = cur;
            if(cur.next != null){
                priorityQueue.add(cur.next);
            }
        }
        return head;

    }
}
