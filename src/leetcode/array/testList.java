package leetcode.array;


import java.util.*;

public class testList {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.get(1);
        // 还是双端队列呢！不再需要什么Deque。

        ArrayList<Integer> a1 = new ArrayList<>();

        // 都是List实现的接口，所以都可以。

        res.add(l1);
        res.add(a1);

        // 不是List的接口。无法res.add()
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new LinkedList<>();
//        res.add(d2);

//        res.add(d1);

    }

}
