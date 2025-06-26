package leetcode.linkedlist;

import java.util.*;

public class LRUCacheArrayList {

    //使用 ArrayList + HashMap 的设计思路
    // get 无：返回-1
    // get 有：1️⃣在list中将值删除,2️⃣在list头插入到最前面，3️⃣返回值
    // put，先get一下判断有没有值，若无：1️⃣在list中采用头插法 2️⃣hashmap添加key value 3️⃣ 判断list有没有满！
    // put 先get一下判断有没有值，若已经有：1️⃣在list中将值删除 2️⃣在头插入到list最前面 3️⃣在hashmap中更新其值

    //缺点：

    //属性
    private final int capacity;
    private final Map<Integer, Integer> map; // 用于快速查找
    private final List<Integer> list;  // 用于维护访问顺序

    public LRUCacheArrayList(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        list = new ArrayList(capacity);
    }

    public int get(int key) {
        Integer i = map.get(key);
        // get无，返回-1
        if (i == null){
            return -1;
        }
        // get有，1️⃣在arraylist中将值删除,2️⃣在头插入到最前面，3️⃣返回值
        list.remove((Object)key);
        list.add(0, key);
        return i;
    }

    public void put(int key, int value) {
        // 先get，发现无：put无，1️⃣在list中采用头插法！ 2️⃣hashmap添加key value
        int i = get(key);
        if (i == -1){
            list.add(0, key);
            map.put(key, value);
            //判断 list 有没有满，满的话要删除list末尾的元素和map里面对应的key-value
            if (list.size() > this.capacity){
                Integer del = list.get(list.size()-1);
                map.remove(del);
                list.remove(list.size()-1);
            }
        }
        // 先get，发现有：put有，1️⃣在list中将值删除 2️⃣在头插入到list最前面 3️⃣在hashmap中改变值
        if (i != -1){
            list.remove((Object)key);
            list.add(0, key);
            map.put(key, value);
        }
    }
}
