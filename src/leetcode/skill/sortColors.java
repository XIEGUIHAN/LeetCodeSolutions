package leetcode.skill;

// 75.颜色分类 -- 荷兰国旗颜色问题

// 两趟循环解决：第一次循环移动0元素；第二次循环移动1元素；

import sun.java2d.pipe.SpanIterator;

public class sortColors {
    public static void sortColorsMethod(int[] nums) {
        // 头部元素
        int first = 0;

        //第一次循环移动0元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                swap(nums ,i, first);
                first++;
            }
        }

        //第一次循环移动1元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                swap(nums ,i, first);
                first++;
            }
        }

    }

    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColorsMethod(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
