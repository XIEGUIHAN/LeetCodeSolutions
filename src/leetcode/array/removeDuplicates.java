package leetcode.array;

// 80.删除有序数组中的重复项II
// 用栈思考，原地实现

public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int stackSize = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[stackSize-2]){
                nums[stackSize] = nums[i];
                stackSize++;
            }
        }
        return Math.min(stackSize, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
        for (int num : nums) {
            System.out.print(num+" ");
        }

    }
}
