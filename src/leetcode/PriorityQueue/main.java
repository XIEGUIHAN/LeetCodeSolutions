package leetcode.PriorityQueue;

public class main {
    public static void main(String[] args) {


//        // 215.数组中的第K个最大元素
//        findKthLargest solution = new findKthLargest();
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        int k = 2;
//        System.out.println(solution.findKthLargestMethod(nums, k)); // 输出: 5


        // 一次性建堆---最大堆
        buildMaxHeap buildMaxHeap = new buildMaxHeap();
        int[] nums = {5,2,3,1};
        int[] ints = buildMaxHeap.buileMaxHeapMethod(nums, 2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }
}
