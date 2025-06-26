package leetcode.matrix;
import java.util.ArrayList;
import java.util.List;

// 54. 螺旋矩阵
// 四个指针转圈圈

public class spiralOrder {
    public List<Integer> spiralOrderMethod(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;

        // 4个指针
        int top = 0, right = column-1, bottom = row-1, left = 0;

        while (top <= bottom && left <= right){ //时刻保证这个条件
            // 从左到右
            if (top <= bottom && left <= right){  //时刻保证这个条件
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }

            // 从上到下
            if (top <= bottom && left <= right){
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            // 从右到左
            if (top <= bottom && left <= right){
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 从下到上
            if (top <= bottom && left <= right) {
                for (int i = bottom; i >= top ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
    }
}
