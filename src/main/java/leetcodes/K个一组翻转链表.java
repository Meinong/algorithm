package leetcodes;

public class K个一组翻转链表 {
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



    //1->2->3->4->5->6
    public static ListNode reverseKGroup(ListNode node, int k) {
        ListNode head = node;
        ListNode start = getEndByNum(node, k);
        ListNode ans = start;
        if(head == null){
            return node;
        }
        ListNode end = reverse(start,head); //返回start 的下一个
        if(end == null){
            return ans;
        }
        while (start != null){
            start = getEndByNum(end,k);
            if(start == null){
                break;
            }
            head.next = start;
            head = end;
            end = reverse(start,end);
            if(end == null){
                break;
            }
        }




        return ans;
    }







    //1->2->3->4
    public static ListNode reverse(ListNode start,ListNode head){
        ListNode end = start.next;
        ListNode last = head;
        ListNode next = null;
        ListNode pre = null;
        while (head !=end){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        last.next = end;
        return end;
    }

    public static ListNode getEndByNum(ListNode start,int k){
        while (--k >0 && start != null){
            start = start.next;
        }
        return start;
    }



    public static void main(String[] args) {

    }
}
