package leetcode.DynamicProgram;

public class minPathSum {
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // 定义dp数组
        int[][] dp = new int[r][c];

        // 初始化dp数组
        dp[0][0] = grid[0][0];
        for (int j = 1; j < c; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 递推公式
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = grid[i][j] + Math.min( dp[i-1][j], dp[i][j-1] );
            }

        }

        return dp[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }
}
