package leetcode.linkedlist;

public class reverseBetween2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 遍历一遍，记录pre和rear
        // 加个虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        ListNode pre = dummyHead;
        ListNode rear = null;
        int curNum = 0;

        while ( cur != null ){
            cur = cur.next;
            curNum++;
            if (curNum + 1 == left){
                pre = cur;
            }
            if (curNum == right + 1){
                rear = cur;
            }
        }

        // 开始反转
        cur = pre.next;
        ListNode first = pre.next; //最后做拼接用
        ListNode preRe = null;

        while (cur != rear ){
            ListNode temp = cur.next;
            cur.next = preRe;
            preRe = cur;
            cur = temp;
        }

        // 拼接链表
        first.next = rear;
        pre.next = preRe;

        return dummyHead.next;
    }
}
