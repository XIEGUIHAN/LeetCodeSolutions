package leetcode.linkedlist;


// 自己写一个工具类的话，需要 属性、方法
public class MyLinkedList {
    // 属性
    public int size;
    public LinkedNode prehead;

    // 定义单链表 结点，可以在类里面再定义一个类吗？可以，它是MyLinkedList算法类的成员
    class LinkedNode{
        int val;
        LinkedNode next;
        LinkedNode(int val){
            this.val = val;
        }
    }

    // 初始化,size为0，prehead初始化一个0节点给它
    public MyLinkedList() {
        this.size = 0;
        prehead = new LinkedNode(0);
    }

    // 头插法-插入元素
    public void addAtHead(int val) {
        LinkedNode node = new LinkedNode(val);
        node.next = prehead.next;
        prehead.next = node;
        this.size++;
    }

    // 获取第index个元素，从0开始哦
    public int get(int index) {
        LinkedNode current = prehead;
        if(index >= size){
            return -1;
        }
        for (int i = index+1; i > 0; i--) {
            current = current.next;
        }
        return current.val;
    }

    // 尾插法 -插入元素
    public void addAtTail(int val) {
        LinkedNode current = prehead;
        // 移动current指针到最后一个 节点 的位置
        for (int i = size; i > 0; i--) {
            current = current.next;
        }
        LinkedNode node = new LinkedNode(val);
        current.next = node;
        size++;
    }

    // 在特定位置index插入
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }else if(index == size){
            addAtTail(val);
        }else {
            LinkedNode current = prehead;
            // 移动current指针到要在特定位置index插入 节点 的前一个的位置
            for (int i = index; i > 0; i--) {
                current = current.next;
            }
            LinkedNode node = new LinkedNode(val);
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    //删除index位置的元素
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        LinkedNode current = prehead;
        // 移动current指针到要删除 节点 的前一个的位置
        //下面代码出错了！
        for (int i = index-1; i >= 0; i--) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }


}



//// 方法二：
//public class MyLinkedList {
//    public int size;
//    public LinkedNode prehead;
//
//    class LinkedNode {
//        int val;
//        LinkedNode next;
//        LinkedNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public MyLinkedList() {
//        this.size = 0;
//        prehead = new LinkedNode(0);
//    }
//
//    public void addAtHead(int val) {
//        LinkedNode node = new LinkedNode(val);
//        node.next = prehead.next;
//        prehead.next = node;
//        this.size++;
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        LinkedNode current = prehead.next;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        return current.val;
//    }
//
//    public void addAtTail(int val) {
//        LinkedNode current = prehead;
//        while (current.next != null) {
//            current = current.next;
//        }
//        LinkedNode node = new LinkedNode(val);
//        current.next = node;
//        size++;
//    }
//
//    public void addAtIndex(int index, int val) {
//        if (index > size) {
//            return;
//        }
//        if (index == 0) {
//            addAtHead(val);
//            return;
//        }
//        if (index == size) {
//            addAtTail(val);
//            return;
//        }
//        LinkedNode current = prehead;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        LinkedNode node = new LinkedNode(val);
//        node.next = current.next;
//        current.next = node;
//        size++;
//    }
//
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index >= size) {
//            return;
//        }
//        LinkedNode current = prehead;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        current.next = current.next.next;
//        size--;
//    }
//}
