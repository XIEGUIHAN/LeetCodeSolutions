package leetcode.DynamicProgram;

// 516.最长回文子序列
// bbbab

public class longestPalindromeSubseq {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        //定义dp数组：dp[i][j]表示区间[i, j]的最长回文子序列
        int[][] dp = new int[len][len];
        // 初始化dp数组对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (charArray[i] == charArray[j]){ // 两端相等
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{ // 两端不相等
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][len-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        int i = longestPalindromeSubseq(s);
        System.out.println(i);
    }
}
