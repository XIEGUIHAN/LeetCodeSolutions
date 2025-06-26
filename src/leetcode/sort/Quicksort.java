package leetcode.sort;

// 快速排序的3中方法之----空穴法，也是教科书以及模拟的方法
// 还有其他的方法不会尝试空穴，而是直接交换。

import java.awt.event.MouseWheelListener;

public class Quicksort {

    // 分区函数
    private static int partition(int[] nums, int left, int right) {
        int mid = nums[left]; // 设置枢纽为第一个元素
        while (left < right){
            while (left < right && nums[right] > mid){
                //右边大于mid，正常，下一个
                right--;
            }
            // 右边小于mid，交换
            nums[left] = nums[right];

            while (left < right && nums[left] < mid){
                //左边小于mid，正常，下一个
                left++;
            }
            // 右边小于mid，交换
            nums[right] = nums[left];
        }
        nums[left] = mid; // 将枢纽放到正确的位置
        return left; // 返回枢纽的位置
    }

    // 快速排序主函数
    public static int[] quickSort(int[] nums, int left, int right) {
        if (left < right){
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid-1);
            quickSort(nums,  mid+1, right);
        }
        return nums;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        int[] nums1 = quickSort(nums, 0, nums.length - 1);
        System.out.println("排序后: " + java.util.Arrays.toString(nums1));
    }

}
