package leetcode.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// 链表相交：利用哈希map记录A链表的每个节点的 地址值 ，然后B的每个节点在一一进行遍历对比
public class linkedListIntersection {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // 创建一个List or set都可以，用来存放A链表的每个节点的地址值
//        LinkedList aList = new LinkedList();
//        // 虚拟A链表头节点
//        ListNode Acurrent = new ListNode(0);
//        Acurrent.next = headA;
//        // 记录A链表的每个节点的地址值
//        while (Acurrent.next != null){
//            aList.add(Acurrent.next);
//            Acurrent = Acurrent.next;
//        }
//
//        // 虚拟B链表头节点
//        ListNode Bcurrent = new ListNode(0);
//        Bcurrent.next = headB;
//        //遍历B链表的每个节点的地址，和aList的值一一比对
//        while (Bcurrent != null){
//            for (int i = 0; i < aList.size(); i++) {
//                if (Bcurrent.next == aList.get(i)){
//                    return Bcurrent.next;
//                }
//            }
//            Bcurrent = Bcurrent.next;
//        }
//
//        // 无交点，则返回null
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aset = new HashSet<>();
        ListNode temp = headA;
        while (temp != null){
            aset.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null){
            if(aset.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}







