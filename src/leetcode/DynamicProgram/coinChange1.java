package leetcode.DynamicProgram;

public class coinChange1 {
    public static int coinChange2(int[] coins, int amount) {

        // dp[i][j] 表示用前 i 种硬币，恰好能够装满 j 的最少硬币数
        int[][] dp = new int[coins.length+1][amount+1];

        // 初始化
        for (int i = 0; i < amount+1; i++) {
            dp[0][i] = amount+1;    //表示达不到
        }
        dp[0][0] = 0;

        //自己二维dp矩阵，画完就能写出dp递推公式：min( dp[i-1][j], dp[i][j-nums[i]+1 ) 画图
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if ( j<coins[i-1] ){
                    dp[i][j] = dp[i-1][j];  // 继承之前的最小硬币数
                }else {
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j-coins[i-1]]+1 );
                }
            }
        }

        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];






//        // 可以先背包 再物品的
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, amount+1);
//        dp[0] = 0;
//
//        for (int i = 0; i <= amount; i++) {
//            for (int coin : coins) {
//                if (i>=coin){
//                    // 要凑的金额数首先得大于当前选择的硬币的面额哈
//                    dp[i] = Math.min( dp[i], dp[i-coin]+1 );
//                }
//            }
//        }
//        return dp[amount]==amount+1 ? -1 : dp[amount];



//        // 求组合数
//        int[] dp = new int[amount + 1];
//        // 初始化
//        Arrays.fill(dp, amount + 1); // 初始化为一个不可能的大数
//        dp[0] = 0;
//
//        // 递推公式 -- 先遍历物品 再遍历背包
//        for( int coin : coins  ){
//            for (int j = 0; j <= amount; j++) {
//                if (j >= coin){
//                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
//                }
//            }
//        }
//
//        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        int i = coinChange2(coins, amount);
        System.out.println(i);
    }
}
