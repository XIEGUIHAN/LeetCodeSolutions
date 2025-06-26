package leetcode.DynamicProgram;

// 718.最长重复子数组

public class longestRepeatingContiguousSubsequence {
    public static int findLength(int[] nums1, int[] nums2) {
        // 状态转移方程：d[i][j]为以下标i为结尾的num1和以下标j为结尾的num2的最长重复子数组的长度
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1][len2];
        int res = 0; // 没有数字相等的情况下为0
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 相等的情况
                if (nums1[i] == nums2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                // else {dp[i][j] = 0;}   // 不相等的情况
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};

        int length = findLength(nums1, nums2);
        System.out.println(length);

    }

//        public static int findLength(int[] nums1, int[] nums2) {
//        int r = nums1.length;
//        int c = nums2.length;
//        int[][] dp = new int[nums1.length][nums2.length];
//        int maxLen = 0;
//
//        // 初始化数组
//        for (int i = 0; i < nums1.length; i++) {
//            dp[i][0] = (nums2[0] == nums1[i]) ? 1 : 0;
//            maxLen = Math.max(maxLen, dp[i][0]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            dp[0][i] = (nums1[0] == nums2[i]) ? 1 : 0;
//            maxLen = Math.max(maxLen, dp[0][i]);
//        }
//
//        // 递推公式
//        for (int i = 1; i < nums1.length; i++) {
//            for (int j = 1; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j] ){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }
//                maxLen = Math.max( maxLen, dp[i][j] );
//            }
//        }
//
//        return maxLen;
//    }
}
