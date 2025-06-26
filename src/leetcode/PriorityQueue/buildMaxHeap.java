package leetcode.PriorityQueue;

// 建最大堆 3, 2, 1, 5, 6, 4   ->   6 5 4 3 2 1

public class buildMaxHeap {

    public int[] buileMaxHeapMethod(int[] nums, int k) {
        int heapsize = nums.length;

        // 从下到上 遍历非叶子节点
        for (int i = heapsize/2-1; i >= 0; i--) {
            // 每个非叶子节点 递归/while的调整其子树为最大堆
            sink(i, nums, heapsize);
        }

        // 交换顶和最下面的元素，直接排序即可
        while (heapsize > 0){   // 易错点
            swap(nums, 0, heapsize-1);
            heapsize--;
            sink(0, nums, heapsize);
        }

        return nums; // 堆顶是第K大元素

    }

    public void sink(int i, int[] nums, int heapsize){
        int l = 2*i+1;
        int r = 2*i+2;
        int large = i;
        if (l<heapsize && nums[l] > nums[large]){// 易错点
            large = l;
        }
        if (r<heapsize && nums[r] > nums[large]){// 易错点
            large = r;
        }
        if (large == i){
            return;
        }
        swap(nums, i,large);
        sink(large, nums, heapsize);
    }

    // 交换堆中元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
