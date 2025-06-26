package leetcode.PriorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// 347. 前 K 个高频元素
// 哈希表+小顶堆
public class topKFrequent {
    public int[] topKFrequentMethod(int[] nums, int k) {

        // 统计各个数字出现的频率
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1 );
            }else{
                map.put(i, 1);
            }
        }

        // 遍历哈希表的value，存入小顶堆，维护一个容量为k的小顶堆
//        如果堆的元素个数小于 k，就可以直接插入堆中。
//        如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
        PriorityQueue<int[]> priorityQueue = new PriorityQueue(k, new Comparator<int[]>() {   //
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        map.forEach((key, value)->{
            System.out.println(value+" ");
            if (priorityQueue.size() < k){
                priorityQueue.offer(new int[]{key, value}); //add插入不了会报错，offer插入不了会返回false
            }else {
                if (value > priorityQueue.peek()[1]){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, value});
                }
            }
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;

    }
}
