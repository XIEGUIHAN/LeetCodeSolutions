package leetcode.PriorityQueue;
import java.util.PriorityQueue;

// 数组中的第K个最大元素
// 堆排序：维护一个容量为k的最小堆

// 空间复杂度 O(k)
// [3,2,1,5,6,4] k=2
public class findKthLargestUseApi {
    public int findKthLargestMethod(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(k);

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        // 维护最小堆-堆已满插入
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();
    }
}
