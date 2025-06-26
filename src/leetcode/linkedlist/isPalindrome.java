package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

// 回文链表
// 思路：将值复制到数组中后用双指针法
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 复制到数组
//        LinkedList<Integer> list = new LinkedList<>();
        ArrayList list = new ArrayList();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        // 双指针法
        int front = 0;
        int rear = list.size()-1;
        while (front < rear){
            if (list.get(front) != list.get(rear)){
                return false;
            }
            front++;
            rear--;
        }
        return true;
    }
}
