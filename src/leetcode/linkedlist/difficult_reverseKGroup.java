package leetcode.linkedlist;

import com.azul.crs.client.service.FirstCallMonitor;

public class difficult_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 虚拟头节点
        ListNode dummphead = new ListNode(-1);
        dummphead.next = head;

        // 由一个pre节点 引出后面的其余3个节点
        ListNode pre = dummphead;

        while (head!=null){
            // 确定翻转区间: pre、left、right、rear
            // head有没有走过k个举例，这个点如何判断呢？
            ListNode left = pre.next;
            ListNode right = pre;

            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i<k ; i++) {
                right = right.next;
                // 走到表尾了 可以返回
                if (right == null) {
                    return dummphead.next;
                }
            }

            ListNode rear = right.next;
            // 到上面这一步，已经确定好了翻转区间

            // 切割要反转的子链表
            pre.next = null;
            right.next = null;

            //翻转链表
            ListNode newnode = reverseLinklist1(left);

            // 把子链表重新接回原链表
            pre.next = newnode;
            left.next = rear;

            // 各个指针移动到下一个待翻转的位置
            pre = left;
        }
        return dummphead.next;
    }


    // 翻转链表1
    public ListNode reverseLinklist1(ListNode head){
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
