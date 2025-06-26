package leetcode.linkedlist;

public class TestMylinkedlist {

    public static void main(String[] args) {
        MyLinkedList mylink = new MyLinkedList();

        // 头插法
        mylink.addAtHead(7);
        mylink.addAtHead(2);
        mylink.addAtHead(1);

        //在特定位置插入元素
        mylink.addAtIndex(3,0);

        //删除特定位置元素
        mylink.deleteAtIndex(2);
        // 头插法
        mylink.addAtHead(6);
        //尾插法
        mylink.addAtTail(4);
        System.out.println(mylink.get(4));

        printLinked(mylink.prehead.next);

    }

    //打印链表
    public static void printLinked(MyLinkedList.LinkedNode head){
        MyLinkedList.LinkedNode current = head;
        while (current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
