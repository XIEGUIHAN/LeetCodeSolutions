package leetcode.linkedlist;

//23.合井K个升序链表
// 维护一个最小堆

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        //创建一个最小堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 新的链表
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;


        for (ListNode list : lists) {
            heap.add(list);
        }

        while (!heap.isEmpty()){
            ListNode peak = heap.poll();
            cur.next = peak;
            cur = cur.next;
            if (peak.next != null){
                heap.add(peak.next);
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {

        TestLinkedList ts = new TestLinkedList();
        int[] l1 = {1,4,5};
        int[] l2 = {1,3,4};
        int[] l3 = {2,6};
        ListNode[] lists = new ListNode[3];
        ListNode list1 = ts.createLinkedMethed(l1);
        ListNode list2 = ts.createLinkedMethed(l2);
        ListNode list3 = ts.createLinkedMethed(l3);

        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        ListNode res = mergeKLists(lists);
        ts.printLinked(res);

    }

}
