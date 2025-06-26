package leetcode.DynamicProgram;

// 322.零钱兑换2

// 类似 爬楼梯

public class coinChange2 {
    public static int change(int amount, int[] coins) {

        // dp[i][j] 表示用前 i 种硬币，恰好能够装满 j 的总硬币的组合数
        int[][] dp = new int[coins.length+1][amount+1];

        // 初始化
        for (int i = 0; i < amount+1; i++) {
            dp[0][i] = 0;    //表示达不到
        }


        //自己二维dp矩阵，画完就能写出dp递推公式：min( dp[i-1][j], dp[i][j-nums[i]+1 ) 画图
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if ( j<coins[i-1] ){
                    dp[i][j] = dp[i-1][j];  // 继承之前的总硬币的组合数
                }else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-coins[i-1]] ) + 1;
                }
            }
        }

        return dp[coins.length][amount];





//        // 求组合数
//        int[] dp = new int[amount + 1];
//        // 初始化
//        dp[0] = 1;
//
//        // 递推公式 -- 先遍历物品 再遍历背包
//        for( int coin : coins  ){
//            for (int j = 0; j <= amount; j++) {
//                if (j >= coin){
//                    // 有3种硬币，故分为3个阶段：放入1元硬币，放入2元硬币，放入5元硬币
//                    // dp[3] = dp[3] + dp[1]；总容量为3的方法数 = 目前的放入方法数 + 容量为1的的方法数再放入2元
//                    dp[j] = dp[j] + dp[j-coin];
//                }
//            }
//        }
//
//        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        int i = change(amount, coins);
        System.out.println(i);
    }
}
