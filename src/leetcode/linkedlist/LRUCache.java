//LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，并且将其移动至访问顺序最前。否则返回 -1 。
//void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value，并且将其移动至访问顺序最前；
//  如果不存在，则向缓存中插入该组 key-value ，并且将其移动至访问顺序最前。
//  如果插入操作导致关键字数量超过 capacity ，则应该 删除 顺序最后的元素。

package leetcode.linkedlist;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //定义LRUCache的属性
    private int capacity;   //容量，定义LRU缓存的最大长度！
    private int size;   //目前的长度 ！
    private Map<Integer, MyLinkedNode> map;  //这个属性必须要写！而且写法要牢记！
    MyLinkedNode head;
    MyLinkedNode tail;

    // 定义一个双向链表MyLinkedNode
    // 为什么不用普通的双向链表LinkedNode呢？
    // 1.虽然LinkedNode底层是双向链表，但是LinkedList不公开内部节点类Node，不能直接操作节点对象，无法配合 HashMap 使用。
    // 2.LinkedList 只能遍历去访问节点,O(n)，无法通过 key 直接访问。无法满足LRU的O(1)要求。
    class MyLinkedNode{      //MyLinkedNode不是和capacity、head、tail一样，它不能理解为LRUCache的属性！
        int key;
        int value;
        MyLinkedNode prev;
        MyLinkedNode next;
        // 构造函数初始化
        MyLinkedNode(){}
        MyLinkedNode(Integer key, Integer value){
            this.key = key;this.value = value;
        }
    }

    // 构造函数，初始化
    LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        // 初始化哈希表 最大容量为2
        this.map = new HashMap<>(capacity);
        // 初始化双向链表：创建虚拟头+尾节点
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // put
    public void put(int key, int value){
        // 判断 map容器 中是否存在该key
        if(map.containsKey(key)){
            // 存在:删除双向链表中的元素，再头插法，再改变node的value值
            deleteMyLinkedNode(map.get(key));
            headInsert(map.get(key));
            map.get(key).value = value;
        }else{
            // 不存在：创建新node，头插法插入双向链表，在map中添加元素，然后判断是否超容
            // 若超容：删除双向链表的尾节点，拿到其key后再在map中删除元素；无超容：无事发生。
            MyLinkedNode newNode = new MyLinkedNode(key, value);
            headInsert(newNode);
            map.put(key, newNode);
            if(map.size() > capacity){
                int deleteKey = tail.prev.key;
                deleteMyLinkedNode(tail.prev);
                map.remove(deleteKey);
            }
        }
    }

    //get
    public int get(int key){
        if (map.containsKey(key)){
            // 若有:删除双向链表中的元素，再头插法插入双向链表，然后返回其value值
            deleteMyLinkedNode(map.get(key));
            headInsert(map.get(key));
            return map.get(key).value;
        }else{
            //若无:返回-1
            return -1;
        }
    }

    // 删除双向链表中的元素：传入要删除的该元素的地址
    public void deleteMyLinkedNode(MyLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 头插法插入双向链表
    public void headInsert(MyLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
