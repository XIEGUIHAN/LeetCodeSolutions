package leetcode.DynamicProgram;

public class uniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        int [][] dp = new int[row][column];

        // 如果起点和终点有障碍物，直接返回0；
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][column-1] == 1){
            return 0;
        }

        // 初始化dp数组
        // 初始化第一行和第一列
        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < column && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;

        // 遍历顺序
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                //如果自己就是障碍物
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }

                //如果上面有障碍物
                if (obstacleGrid[i-1][j] == 1){
                    dp[i][j] = dp[i][j-1];
                }
                //如果左边有障碍物
                if (obstacleGrid[i][j-1] == 1){
                    dp[i][j] = dp[i-1][j];
                }

                //如果上面和左边有障碍物
                if (obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1){
                    dp[i][j] = 0;
                }

                // 如果上面和下面都畅通
                if ((obstacleGrid[i-1][j] == 0 && obstacleGrid[i][j-1] == 0)){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
}
