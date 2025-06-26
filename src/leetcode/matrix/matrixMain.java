package leetcode.matrix;

import java.util.Arrays;
import java.util.List;

public class matrixMain {
    public static void main(String[] args) {

        // 合并区间
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        mergedInterval mi = new mergedInterval();
//        int[][] res = mi.mergedIntervalMethod(intervals);
//        String string = Arrays.deepToString(res);
//        System.out.println(string);


        // 螺旋矩阵
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder so = new spiralOrder();
        List<Integer> list = so.spiralOrderMethod(matrix);
        System.out.println(list);


    }
}
