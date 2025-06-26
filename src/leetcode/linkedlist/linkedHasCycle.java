package leetcode.linkedlist;

import java.util.HashSet;

// 判断一个链表有没有 环
public class linkedHasCycle {
    //法一：哈希表。记录有相同的节点就有环
    public boolean hasCycle(ListNode head) {
        HashSet set = new HashSet();
        ListNode temp = head;

        while (temp != null){
            if (!set.add(temp)){
                return true;
            }
            temp = temp.next;

        }
        return false;
    }
}
