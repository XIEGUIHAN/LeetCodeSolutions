package leetcode.PriorityQueue;

import java.security.Key;
import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueueMain {

    public static void main(String[] args) {
//        int[] arr = {1,1,1,2,2,3};
//        int k = 2;
//
//        topKFrequent tk = new topKFrequent();
//        int[] ints = tk.topKFrequentMethod(arr, k);
//
//        for (int i : ints) {System.out.print(i+" ");}


        // 堆排序 -- 数组中的第K个最大元素
        int[] array = {3,2,1,5,6,4};
        findKthLargest find = new findKthLargest();
        int result = find.findKthLargestMethod(array, 2);

        System.out.println(result);

    }

}
