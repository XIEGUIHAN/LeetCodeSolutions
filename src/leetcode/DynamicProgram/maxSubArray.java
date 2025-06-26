package leetcode.DynamicProgram;
// 53. 最大子数组和 ---动态规划

// dp[i]：以nums[i]为结尾的最大连续子数组和为dp[i]。
public class maxSubArray {
    public int maxSubArrayMethed(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max( dp[i-1]+nums[i], nums[i] );
            if ( result<dp[i] ){
                result = dp[i];
            }
        }
        return result;
    }
}