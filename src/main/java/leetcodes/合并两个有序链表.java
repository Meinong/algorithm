package leetcodes;

import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,1,4], l2 = [2,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * [4]
 * [1,1,2,3,4]
 */
public class 合并两个有序链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2 == null && list1 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode ans = new ListNode();
        ListNode curAns = ans;
        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                curAns.next = list2;
                ListNode next = list2.next;
                list2.next = null;
                list2 = next;
            }else{
                curAns.next = list1;
                ListNode next = list1.next;
                list1.next = null;
                list1 = next;
            }
            curAns = curAns.next;
        }

        if (list1 != null){
            curAns.next = list1;
        }
        if (list2 != null){
            curAns.next= list2;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
