package leetcode.DynamicProgram;

// 152.乘积最大子数组。第一眼动态规划。后来发现有负数，规划不来。不是一般的动态规划。
// 解法：不仅要维护最大值dp数组，还要维护最小值负数的dp数组。

public class maxProduct {
    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max( maxDp[i-1]*nums[i], Math.max( nums[i], minDp[i-1]*nums[i] ) );
            minDp[i] = Math.min( maxDp[i-1]*nums[i], Math.min( nums[i], minDp[i-1]*nums[i] ) );
        }

        int max = maxDp[0];
        for (int i = 0; i < maxDp.length; i++) {
            max = Math.max( max, maxDp[i] );
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,3,-4};
        int[] nums = {2,3,-2,4};
        maxProduct maxProduct = new maxProduct();
        int maxone = maxProduct.maxProduct(nums);
        System.out.println(maxone);
    }
}
