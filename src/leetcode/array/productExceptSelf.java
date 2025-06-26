package leetcode.array;

public class productExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        // 计算前缀积
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int leftsum = 1;
        int rightsum = 1;
        L[0] = 1;
        R[length-1] = 1;

        for (int i = 1; i < length; i++) {
            leftsum = leftsum * nums[i-1];
            L[i] = leftsum;
        }

        for (int i = length-2; i >= 0; i--) {
            rightsum = rightsum * nums[i+1];
            R[i] = rightsum;
        }

        for (int i = 0; i < length; i++) {
            nums[i] = L[i] * R[i];
        }

        return nums;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }
}
