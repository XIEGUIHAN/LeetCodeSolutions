package leetcode.linkedlist;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode l3 = new ListNode(-1);
        l3.next = null;
        ListNode curr = l3;
        int index = 0;
        while(l1 != null || l2!= null){
            int nodeVal = l1.val + l2.val;
            // 进制位上为1
            if( index == 1){
                nodeVal += 1;
                index = 0;  //复原
            }
            //进制处理
            if(nodeVal >= 10){
                // 取个分位
                nodeVal = nodeVal % 10;
                index = 1;
            }
            ListNode node = new ListNode(nodeVal);
            curr.next = node;
            curr = curr.next;
            // 长度不够的一端补0
            if(l1.next == null && l2.next != null){
                l1.next = new ListNode(0);
            }
            if (l2.next == null && l1.next != null){
                l2.next = new ListNode(0);
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        // 最后进位为1
        if (index == 1){
            ListNode node = new ListNode(1);
            curr.next = node;
        }
        return l3.next;
    }
}









//public class addTwoNumbers {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // 虚拟头节点
//        ListNode l3 = new ListNode(-1);
//        l3.next = null;
//        ListNode curr = l3;
//        int index = 0;
//        while(l1 != null && l2!= null){
//            int nodeVal = l1.val + l2.val;
//            // 进制位上为1
//            if( index == 1){
//                nodeVal += 1;
//                index = 0;  //复原
//            }
//            //进制处理
//            if(nodeVal >= 10){
//                // 取个分位
//                nodeVal = nodeVal % 10;
//                index = 1;
//            }
//            ListNode node = new ListNode(nodeVal);
//            curr.next = node;
//            curr = curr.next;
//
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        // 边界条件：两个链表长度不相等；遍历完进位仍为1
//        while(l1 != null || l2!= null || index == 1){
//            int nodeVal = 0;
//            if(l1 != null){
//                nodeVal = l1.val;
//                l1 = l1.next;
//            }else if(l2 != null){
//                nodeVal = l2.val;
//                l2 = l2.next;
//            }
//            // 进制位上为1
//            if( index == 1){
//                nodeVal += 1;
//                index = 0;  //复原
//            }
//            //进制处理
//            if(nodeVal >= 10){
//                // 取个分位
//                nodeVal = nodeVal % 10;
//                index = 1;
//            }
//            ListNode node = new ListNode(nodeVal);
//            curr.next = node;
//            curr = curr.next;
//        }
//
//        return l3.next;
//    }
//}
