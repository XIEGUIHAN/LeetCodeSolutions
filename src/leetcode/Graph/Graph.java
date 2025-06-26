package leetcode.Graph;

// 200.岛屿的数量

public class Graph {
    public static int numIslands(char[][] grid) {
        int islandNums = 0;
        // 遍历矩阵中的每个元素
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 这一步刚才没想到！岛屿的数量应该在外面if的时候加加
                if (grid[i][j] == '1') {
                    islandNums++;
                    DFS(grid, i, j);
                }
            }
        }

        return islandNums;
    }

    public static void DFS(char[][] grid, int row, int column) {
        // 遍历到边界了，返回
        if (!isover(grid, row, column)){
            return;
        }
        if (grid[row][column] != '1'){
            return;
        }
        grid[row][column] = '2';

        DFS(grid, row, column+1);
        DFS(grid, row, column-1);
        DFS(grid, row+1, column);
        DFS(grid, row-1, column);

    }

    public static boolean isover(char[][] grid, int row, int column){
        if (row<0 || row>grid.length-1 || column<0 || column>grid[0].length-1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int i = numIslands(grid);
        System.out.println(i);
    }
}
