package leetcode.linkedlist;


// 输入：head = [1,2,3,4,5], n = 2即删除倒数第2个节点。 输出：[1,2,3,5]
// 解法1️⃣：只要快慢指针中间隔 n 个结点即可！
// 解法2️⃣：也是快慢指针，快指针 数出一共有多少个节点，慢指针 执行删除即可。
public class RemoveNthFromEnd {
    // 移除倒数第n个元素
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // 定义快慢指针、虚拟头节点
//        ListNode virtalHead = new ListNode(0);
//        virtalHead.next = head;
//
//        ListNode fast = virtalHead;
//        ListNode slow = virtalHead;
//
//        // 快指针先走n+1步
//        for (int i = 0; i < n+1; i++) {
//            fast = fast.next;
//        }
//        // 快慢指针一起走，直到快指针走到链表尾部
//        while (fast != null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        //此时slow就是倒数第n个节点的前一个节点了，可以进行删除or添加操作了
//        slow.next = slow.next.next; //删除下一个节点
//        return virtalHead.next;
//    }

    // 法二：
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        // 定义快慢指针、虚拟头节点
        ListNode virtalHead = new ListNode(0);
        virtalHead.next = head;

        ListNode fast = virtalHead;
        ListNode slow = virtalHead;

        while (fast != null){
            fast = fast.next;
            size++;
        }
        for (int i = 0; i < size-n-1; i++) {
            slow = slow.next;
        }
        //此时slow就是倒数第n个节点的前一个节点了，可以进行删除or添加操作了
        slow.next = slow.next.next; //删除下一个节点
        return virtalHead.next;

    }
}
