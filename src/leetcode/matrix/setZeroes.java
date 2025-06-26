package leetcode.matrix;

import java.util.HashSet;

//73.矩阵置零
public class setZeroes {
    public void setZeroesMethod(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                if (matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        // 根据标记数组再次遍历数组-置0

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || column.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
