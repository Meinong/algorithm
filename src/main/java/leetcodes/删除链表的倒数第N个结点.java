package leetcodes;


import java.util.HashMap;
import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class 删除链表的倒数第N个结点 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //找到第n个是谁，找到n-1个是谁
        //之后 n-1.next = n.next
        // n.next=null
        if(head == null){
            return head;
        }
        HashMap<Integer,ListNode> listNodeHashMap = new HashMap<>();
        ListNode curNode = head;
        int index = 1;
        while (curNode != null){
            listNodeHashMap.put(index,curNode);
            curNode = curNode.next;
            index++;
        }
        if(index - 1 < n){
            return head;
        }
        ListNode ans = head;
        if(index-n == 1){ //如果是第一个
            ans = head.next;
            head.next = null;
            return ans;
        }

        curNode = listNodeHashMap.get(index - n); // index-1-n+1
        listNodeHashMap.get(index - n -1).next = curNode.next;
        curNode.next = null;
        return ans;
    }


    //采用栈
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null){
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null){
            stack.push(curNode);
            curNode = curNode.next;
        }
        ListNode listNode = null;

        while (n > 0){
            listNode = stack.pop();
            n--;
        }

        if (listNode == null){
            return head;
        }


        if(listNode == head){
            ListNode nextListNode = listNode.next;
            listNode.next = null;
            return nextListNode;
        }

        ListNode listNodePre  = stack.pop();
        listNodePre.next = listNode.next;
        listNode.next = null;
        return head;
    }


    //[1,2,3,4,5], n = 2
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }


}





