package leetcode.DynamicProgram;

// 416. 分割等和子集------ 01背包

public class SplittingEqualAndSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int target = sum / 2;
        if (sum % 2 != 0){
            // 总和为奇数，直接返回false
            return false;
        }

        // 转化为01背包问题
        boolean res = false;
        // 定义dp数组：dp[j]表示是否存在一个子集，使得其和恰好为j；
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j-num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,7,5};

        SplittingEqualAndSubset sp = new SplittingEqualAndSubset();
        boolean b = sp.canPartition(nums);
        System.out.println(b);
    }
}
