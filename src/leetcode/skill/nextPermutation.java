package leetcode.skill;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class nextPermutation {
    public static void nextPermutation(int[] nums) {
        // 从后往前遍历，找到第一对降序的数据对
        // 固定降序对中的前一个数a，把第二个数i到数组末尾的元素b 从大到校排序。其实这部分是倒数的，简单，只需要双指针交换即可。
        // 然后在排好序的数组中找到第一个大于a的数，交换。ok
        int len = nums.length;
        for (int i = len-1; i >= 1 ; i--) {
            if (nums[i] > nums[i-1]){
                //固定i-1，将i到后面的数排序---其实即反转
                reverse(nums, i, len-1);
                // 在排好序的数组中找到第一个大于a的数，交换。ok
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1]){
                        swap(nums, j ,i-1);
                        break;
                    }
                }
                break;
            }
            if(i == 1) {
                // 说明是这样的形式 5 4 3 2 1 那么直接反转就好了
                reverse(nums, 0, len-1);
            }
        }


    }
    public static void reverse(int[] nums, int l, int r){
        while (l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public static void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
