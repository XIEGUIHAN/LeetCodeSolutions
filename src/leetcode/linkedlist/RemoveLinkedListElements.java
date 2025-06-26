//leetcode-203
package leetcode.linkedlist;

/**
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 输入：head = [], val = 1
 * 输出：[]
 */

public class RemoveLinkedListElements {
    //定义单链表结点
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 创建链表
    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // 如果数组为空，返回null
        }

        // 创建链表的头节点
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // 遍历数组，创建链表的其余节点
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;  // 将当前节点的next指向新创建的节点
            current = newNode;       // 移动当前节点到新节点
        }

        return head; // 返回链表的头节点
    }

    //打印链表
    public void printLinked(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // 移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHeader = new ListNode(-1);
        preHeader.next = head;

        ListNode current = preHeader;
        while (current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else {
                // 必须加上 else，否则会跳过连续相同值的节点 比如2 6 6 6
                current = current.next;
            }
        }
        // 不能返回head，因为head有可能会被删除
        return preHeader.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements obj = new RemoveLinkedListElements();  // 创建对象
        int[] arr = {1, 2, 6, 3, 6, 10, 6};
        ListNode head = obj.createLinkedList(arr);

        ListNode result = obj.removeElements(head, 6);

        obj.printLinked(result);

    }
}
