package leetcode.sort;

import java.util.Arrays;

public class QuietSortII {

    static void quietSort(int[] nums, int start, int end){
        // 递归终止条件
        if(start >= end ) {
            return;
        }
        int mid = nums[start];// 基准点
        int left = start;
        int right= end;

        while (left < right){
            while (nums[right] >= mid && left < right){right--;}
            while (nums[left] <= mid && left < right){left++;}
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        // l和r相遇，则找到基准点的最终位置了。基准点移到正确位置
        int temp2 = nums[left];
        nums[left] = nums[start];
        nums[start] = temp2;

        // 递归
        quietSort(nums, start, left-1);
        quietSort(nums, left+1, end);
    }

    public static void main(String[] args) {
        int[] nums = {5,6,1,3,2,4};
        quietSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


