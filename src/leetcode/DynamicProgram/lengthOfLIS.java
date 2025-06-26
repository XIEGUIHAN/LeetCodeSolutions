package leetcode.DynamicProgram;

// leetcode 300:最长递增子序列

public class lengthOfLIS {
    public int lengthOfLISMethod(int[] nums) {
        // 定义一个dp数组，从任意位置开始但以nums[i]元素作为结尾的【所有递增子序列】中的最长的子序列长度。即nums[i]必须是该子序列里值最大的元素。
        int[] dp = new int[nums.length];
        // 初始化为1
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        // 递推公式
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        //最后遍历dp数组取最大的值
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
