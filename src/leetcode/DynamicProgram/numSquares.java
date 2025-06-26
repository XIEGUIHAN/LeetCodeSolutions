package leetcode.DynamicProgram;
import java.util.ArrayList;

// 279.完全平方数 --- 完全背包--二维dp数组

public class numSquares {
    public int numSquares(int n) {

        // 硬币的种类和数量自己计算和生成
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i*i <= n){
                coins.add(i*i);
            }
        }

        // dp[i][j] 表示用前 i 种硬币，恰好能够装满 j 的最少硬币数
        int[][] dp = new int[coins.size()+1][n+1];

        // 初始化
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = n+1;    //表示达不到
        }
        dp[0][0] = 0;

        //自己二维dp矩阵，画完就能写出dp递推公式：min( dp[i-1][j], dp[i][j-nums[i]+1 ) 画图
        for (int i = 1; i <= coins.size(); i++) {
            for (int j = 0; j <= n; j++) {
                if ( j<coins.get(i-1) ){
                    dp[i][j] = dp[i-1][j];  // 继承之前的最小硬币数
                }else {
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j-coins.get(i-1)]+1 );
                }
            }
        }

        return dp[coins.size()][n] == n+1 ? -1 : dp[coins.size()][n];
    }

    public static void main(String[] args) {
        numSquares numSquares = new numSquares();
        int i = numSquares.numSquares(1);
        System.out.println(i);

    }
}
