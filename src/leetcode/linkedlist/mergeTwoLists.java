//21. 合并两个有序链表
package leetcode.linkedlist;

// 思路： 双指针，迭代法 交替判断即可
public class mergeTwoLists {
    public ListNode mergeTwoListsmethod(ListNode list1, ListNode list2) {
//        if(list1==null){
//            return list2;
//        }
//        if(list2==null){
//            return list1;
//        }
//        ListNode newHead = null;
//        ListNode pnew = null;
//        ListNode pold = null;
//        if (list1.val <= list2.val){
//            newHead = list1;
//            pnew = list1.next;
//            pold = list2;
//        }else {
//            newHead = list2;
//            pnew = list2.next;
//            pold = list1;
//        }
//
//        // 迭代判断
//        ListNode current = newHead;
//        while (pnew != null && pold != null){
//            if (pnew.val <= pold.val){
//                current.next = pnew;
//                pnew = pnew.next;
//            }else {
//                current.next = pold;
//                pold = pold.next;
//            }
//            current = current.next;
//        }
//
//        if (pnew == null){
//            current.next = pold;
//        }else {
//            current.next = pnew;
//        }
//
//        return newHead;


        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = list1 == null ? list2 : list1;

        return prehead.next;
    }
}
