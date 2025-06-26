package leetcode.exam;

import java.util.*;

// 反转N个一组链表：把链表每N个节点划分为一组，把这些组整体顺序反转。

public class revertNnode {

    //定义链表节点
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    //将链表每N个节点作为一个分组，然后将这些分组整体逆序拼接成一个新的链表
    public static ListNode reverseEveryNGroup(ListNode head, int N) {
        // 特殊边界情况
        if (head == null || N <= 0) return head;
        // 保存每个分组的头节点
        List<ListNode> groupHeads = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            ListNode groupHead = curr;
            int count = 1;

            // 找到当前分组的尾节点（第N个节点）
            while (count < N && curr.next != null) {
                curr = curr.next;
                count++;
            }
            // 暂存下一个分组的起始节点
            ListNode nextGroup = curr.next;
            // 断开当前的分组
            curr.next = null;
            // 将当前分组头加入列表
            groupHeads.add(groupHead);
            // 处理下一个分组
            curr = nextGroup;
        }

        // 逆序拼接这些分组
        Collections.reverse(groupHeads);

        ListNode newHead = null;
        ListNode tail = null;

        for (ListNode node : groupHeads) {
            if (newHead == null) {
                newHead = node;
                tail = getTail(node);
            } else {
                tail.next = node;
                tail = getTail(node);
            }
        }

        return newHead;
    }

    //获取链表的尾节点
    private static ListNode getTail(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    //根据传入数组创建单链表
    public static ListNode buildList(int[] vals) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    //打印链表
    public static void printLinked(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print("->");
            current = current.next;
        }
        System.out.println();
    }

    // 主函数
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2}
        };
        int[] ns = {2, 1, 2};

        for (int i = 0; i < inputs.length; i++) {
            int[] input = inputs[i];
            int n = ns[i];

            System.out.print("Input = ");
            printLinked(buildList(input));
            System.out.println("N = " + n);

            ListNode result = reverseEveryNGroup(buildList(input), n);
            System.out.print("Output = ");
            printLinked(result);
            System.out.println();
        }
    }
}
