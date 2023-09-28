package com.huaizhu;

/**
 * 1.设置两个指针 快F 慢s (快走两步，慢走一步)
 * 2.当两个指针相遇时 快指针回到开头
 * 3.当两个指针在次相遇时，节点为回环节点
 */
public class 判断是否是回环链表并且找到第一个回环节点 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public static Node test(Node head1,Node head2) {
        if(head2 == null || head1 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            //1.
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            //3.
            return bothLoop(head1,loop1,head2,loop2);
        }
        //2.
        return null;

    }

    //3. 3中情况
    //3.1 loop1 == lopp2 ==> 呈现的是Y形状 解题思路和无环的一样
    //3.2 loop1 走一圈回到自己 没发现loop2 那么不相交
    //3.2 loop1 走一圈发现了loop2 相交 那么(loop1 和 loop2 都是相交点)

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

        if (loop1 == loop2) {
            //3.1情况
            return noLoop(loop1,loop2); //Y 型
        }else{
            //3.2 和 3.3 情况
            Node cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }


    //2.head1 和 head2 一个有环 一个无环 -->不会相交 （只有一个next）

    //1.head1 和 head2 都是无环
    public static Node noLoop(Node head1, Node head2) {
        if (head2 == null || head1 == null) {
            return null;
        }
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur2 != cur1) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    //获取回环地址
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow fast 相遇
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
