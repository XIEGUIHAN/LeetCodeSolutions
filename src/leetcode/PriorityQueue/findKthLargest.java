package leetcode.PriorityQueue;
// 数组中的第K个最大元素
// 堆排序：建完整堆+弹出元素+维护



// 方法一： 动态维护一个k的小顶堆
public class findKthLargest {
    int k = 0;
    int[] heap;
    int size = 0;

    public int findKthLargestMethod(int[] nums, int k) {
        heap = new int[k];
        size = 0;   // 堆中的容量
        for (int i = 0; i < nums.length; i++) {
            if (size < k){
                // 堆中数组还未满，直接插入，然后上浮
                //插入
                heap[size] = nums[i];
                size++;
                //上浮
                swim(i);

            } else if (nums[i] > heap[0] ) {
                // 当前元素 比 堆顶元素 大 ，弹出堆顶，替换
                heap[0] = nums[i];
                // 下沉操作
                sink(0);
            }
            // 堆满 且 当前元素比堆顶元素小，跳过
        }
        return heap[0]; // 堆顶是第K大元素
    }

    // 上浮--插入
    public void swim( int i ){
        while (i > 0 && heap[i] < heap[ (i-1)/2 ]){
            // 插入的元素比父节点小，上浮
            swap(i , (i-1)/2);
            // 继续判断是否比父节点小
            i = (i-1)/2;
        }
    }

    // 下沉--替换后下沉
    public void sink( int i ){
        // 比子节点大, 替换掉子节点中较小的那个
        while (2*i+1<size){
            int j = 2*i+1;
            if (2*i+2<size && heap[2*i+2] < heap[2*i+1]){
                j = 2*i+2;
            }
            if (heap[i] <= heap[j]) {
                break; // 当前节点已是最小
            }
            swap(i, j);
            i = j;
        }
    }


    // 交换堆中元素
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}







// 方法二：一次性建立最大堆，然后弹出。
//public class findKthLargest {
//    public int findKthLargestMethod(int[] nums, int k) {
//        int heapsize = nums.length;
//
//        // 建完整堆:
//        // 从最后一个非叶子节点向前遍历,每个节点下沉调整
//        for (int i = heapsize/2-1; i>=0; i--) {
//            sinkAdjust(i, nums, heapsize);
//        }
//
//        // 弹出元素+维护
//        // 将堆顶元素（最大值）与堆的最后一个元素交换
//        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//            swap(nums, 0, i);
//            heapsize--; // 堆的大小减 1
//            sinkAdjust(0, nums, heapsize); // 调整堆，使其重新满足最大堆性质
//        }
//        return nums[0]; // 返回堆顶元素，即第 k 个最大元素
//    }
//
//    //下沉调整函数-最大堆
//    public void sinkAdjust(int i, int[] heap, int heapSize){
//        int l = i * 2 + 1; // 左子节点
//        int r = i * 2 + 2; // 右子节点
//        int largest = i;   // 当前节点
//
//        // 找到当前节点及其子节点中的最大值
//        if (l < heapSize && heap[l] > heap[largest]) {
//            largest = l;
//        }
//        if (r < heapSize && heap[r] > heap[largest]) {
//            largest = r;
//        }
//        // 如果当前节点不是最大值，则交换并递归调整
//        if (largest != i) {
//            swap(heap, i, largest);
//            sinkAdjust(largest, heap, heapSize); // 递归调整子树
//        }
//        // 如果i最大，则啥也不干，回溯
//
//    }
//
//    public void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
//}
