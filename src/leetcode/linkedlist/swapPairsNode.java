package leetcode.linkedlist;

public class swapPairsNode {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null){ // 才不结束
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
