package leetcode.linkedlist;


//输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
// 三指针法！pre current tail对的，tail可以等到循环的时候再创建！
//
//public class ReverseLinkedlist {
//    public static ListNode reverseList(ListNode head) {
//        if (head == null){
//            return null;
//        }
//        ListNode current = head;
//        ListNode pre = null;
//        ListNode tail = head.next;
//        while (current != null){
//            // 反转指针
//            current.next = pre;
//            // 轮流前移，从pre开始
//            pre = current;
//            current = tail;
//            if(tail != null){
//                tail = tail.next;
//            }
//        }
//        // 注意，最后是返回pre
//        head = pre;
//        return head;
//    }
//}

//输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
//官方正解！
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//}

// 方法三：头插法+虚拟头节点
public class ReverseLinkedlist {
    public static ListNode reverseList(ListNode head) {
        ListNode virtualHead = new ListNode(0);
        while (head != null){
            ListNode temp = head.next;

            head.next = virtualHead.next;
            virtualHead.next = head;
            head = temp;
        }
        return virtualHead.next;
    }
}

