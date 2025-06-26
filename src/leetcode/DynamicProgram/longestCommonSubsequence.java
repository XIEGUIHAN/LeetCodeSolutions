package leetcode.DynamicProgram;

// 300.最长公共子序列
public class longestCommonSubsequence {
    public static int longestCommonSubsequenceMethod(String text1, String text2){
        int maxlen = 0;
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int len1 = text1.length();
        int len2 = text2.length();
        // dp[i][j]表示(0,i)的序列 和 (0,j)的序列的最长公共子序列的长度。
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (array1[i] == array2[j]){
                    //如果两个数相等
                    if (i==0 || j==0){  // 单独处理第1行和第1列
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }else {
                    //如果不相等
                    if ( i==0 && j==0){ // 单独处理第1个元素
                        dp[i][j] = 0;
                    } else if (i==0){  // 单独处理第1行和第1列
                        dp[i][j] = Math.max( 0, dp[i][j-1] );
                    } else if (j==0) {  // 单独处理第1行和第1列
                        dp[i][j] = Math.max( dp[i-1][j], 0 );
                    } else {    // 处理其余行
                        dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                    }
                }
                maxlen = Math.max( maxlen, dp[i][j] );
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";

        int length = longestCommonSubsequenceMethod(text2, text1);
        System.out.println(length);

    }
}
