package leetcode.DynamicProgram;

// 62. 不同路径1---矩阵中左上角到右下角的总路径数
public class uniquePaths {
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];

        // 初始化dp数组
        // 错误dp[0][0] = 1;
        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // 遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int i = uniquePaths(4, 5);
        System.out.println(i);
    }
}
