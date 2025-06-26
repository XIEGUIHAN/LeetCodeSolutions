package leetcode.DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int[][] dp = new int[numRows][numRows];
        // 行列初始化 为1
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            if (i>=1){
                dp[i][i] = 1;
            }
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 0; j < i; j++) {
                if (j>=1){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                path.add(dp[i][j]);
            }
            res.add(new ArrayList<>(path));
            path.clear();
        }

        return res;
    }

    public static void main(String[] args) {
        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        List<List<Integer>> result = yangHuiTriangle.generate(5);
        System.out.println(result);
    }
}
