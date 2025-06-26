package leetcode.linkedlist;

public class createLinkedList {
    //定义单链表节点
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){  //构造方法
            this.val = val;
            this.next = null;
        }
    }

    //根据传入数组创建单链表
    public ListNode createLinkedMethed(int[] array){
        // 首元节点
        ListNode head = new ListNode(array[0],null);
        ListNode current = head;

        for(int i=1; i<array.length; i++){
            ListNode node = new ListNode(array[i], null);
            current.next = node;
            current = node;
        }
        return head;
    }

    //打印链表
    public void printLinked(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
    }


    public static void main(String[] args) {
        createLinkedList c = new createLinkedList();
        int[] array = {5,7,0,2};
        ListNode head = c.createLinkedMethed(array);
        c.printLinked(head);
    }


}
