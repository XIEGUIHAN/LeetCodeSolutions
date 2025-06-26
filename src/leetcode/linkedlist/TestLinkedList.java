package leetcode.linkedlist;


public class TestLinkedList {

    //根据传入数组创建单链表
    public ListNode createLinkedMethed(int[] array){
        // 首元节点
        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        for(int i=1; i<array.length; i++){
            ListNode node = new ListNode(array[i]);
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
        System.out.println();
    }

    // 主函数
    public static void main(String[] args) {
        TestLinkedList obj = new TestLinkedList();
//        int[] array = {1,2,3,4,5};
//        // 根据数组创建链表
//        ListNode head = obj.createLinkedMethed(array);
//        obj.printLinked(head);


//        // 反转链表
//        ListNode result = ReverseLinkedlist.reverseList(head);
//        obj.printLinked(result);

//        // 删除倒数第n个节点
//        RemoveNthFromEnd remove = new RemoveNthFromEnd();
//        remove.removeNthFromEnd(head,2);
//        obj.printLinked(head);


//        // 根据数组创建链表
//        int[] Aarray = {4,1,8,4,5};
//        ListNode Ahead = obj.createLinkedMethed(Aarray);
//        int[] Barray = {5,0,1,8,4,5};
//        ListNode Bhead = obj.createLinkedMethed(Barray);
//
//        // 找到链表相交的交点
//        linkedListIntersection ll = new linkedListIntersection();
//        ListNode intersectionNode = ll.getIntersectionNode(Ahead, Bhead);
//
//        System.out.println(intersectionNode.val);

//        // 合并两个有序链表
//        int[] array1 = {1,2,4};
//        ListNode List1 = obj.createLinkedMethed(array1);
//        int[] array2 = {1,3,4};
//        ListNode List2 = obj.createLinkedMethed(array2);
//        mergeTwoLists m = new mergeTwoLists();
//        ListNode result = m.mergeTwoListsmethod(List1, List2);
//
//        obj.printLinked(result);


//        // 两两交换链表节点
//        int[] array1 = {1,2,3,4};
//        ListNode List1 = obj.createLinkedMethed(array1);
//        swapPairsNode swap = new swapPairsNode();
//        ListNode result = swap.swapPairs(List1);
//        obj.printLinked(result);


//        //LRU缓存"put", "put", "get", "put", "get", "put", "get", "get", "get"
//        LRUCacheArrayList lru = new LRUCacheArrayList(2);
//        lru.put(1, 1);
//        lru.put(2, 2);
//        System.out.println(lru.get(1));
//        lru.put(3, 3);
//        System.out.println(lru.get(2));
//        lru.put(4, 4);
//        System.out.println(lru.get(1));
//        System.out.println(lru.get(3));
//        System.out.println(lru.get(4));


        // 反转链表2
//        reverseBetween2  re2 = new reverseBetween2();
//        int[] array = {3,5};
//        // 根据数组创建链表
//        ListNode head = obj.createLinkedMethed(array);
//        ListNode res = re2.reverseBetween(head, 1, 2);
//        obj.printLinked(res);


        // k个一组反转链表
//        difficult_reverseKGroup dif = new difficult_reverseKGroup();
//        int[] array = {1,2,3,4,5};
//        ListNode head = obj.createLinkedMethed(array);
//        ListNode result = dif.reverseKGroup(head, 2);
//        obj.printLinked(result);

        // 两数相加
        addTwoNumbers add = new addTwoNumbers();
        int[] array1 = {2,4,3};
        int[] array2 = {5,6,4};
        // 根据数组创建链表
        ListNode list1 = obj.createLinkedMethed(array1);
        ListNode list2 = obj.createLinkedMethed(array2);
        ListNode l3 = add.addTwoNumbers(list1, list2);
        obj.printLinked(l3);

    }


}
