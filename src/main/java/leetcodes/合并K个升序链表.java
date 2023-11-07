package leetcodes;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 */
public class 合并K个升序链表 {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ansNode = new ListNode();
        ListNode headNode = ansNode;
        if (lists == null) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }
        //lists.length > 1
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int N = lists.length;
        for (int i = 0; i < N; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }
        if(queue.isEmpty()){
            return null;
        }

        while (!queue.isEmpty()){
            ListNode curNode = queue.poll();
            ansNode.next = curNode;
            ansNode = ansNode.next;
            if(curNode.next != null){
                ListNode curNextNode = curNode.next;
                curNode.next = null;
                queue.offer(curNextNode);
            }
        }
        return headNode.next;
    }

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);


        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode listNode = mergeKLists(lists);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
