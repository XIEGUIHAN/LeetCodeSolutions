package leetcode.linkedlist;

public class addTwoLinkedNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        double result = 0;
        int i = 0;

        while (l1 != null && l2 != null){
            if (l1 == null){
                result = result + l2.val*Math.pow(10, i);
                l2 = l2.next;
            }
            if (l2 == null){
                result = result + l1.val*Math.pow(10, i);
                l1 = l1.next;
            }
            if (l1 != null && l2 != null){
                result = result + l1.val*Math.pow(10, i) + l2.val*Math.pow(10, i);
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        String strnumber = String.valueOf(result);
        ListNode head = new ListNode(strnumber.charAt(0));
        ListNode current = head;
        for (int j = 1; j < strnumber.length()-1; j++) {
            ListNode node = new ListNode(strnumber.charAt(j));
            current.next = node;
            current = current.next;
        }

        return head;
    }
}
