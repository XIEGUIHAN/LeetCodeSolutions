package leetcode.DynamicProgram;

// 5，最长回文子串
public class longestPalindrome {

    public static String longestPalindrome(String s) {
        //  中心扩散法
        //  朴素的想法：计算以每个字符为中心的回文子串，然后取最大值即可。

        if (s == null || s.length() == 1) {return s;}

        int maxLeft = 0;
        int maxright = 0;
        int maxLen = 0;
        char[] array = s.toCharArray();
        int len = array.length;

        // 不用分整个字符串是奇数还是偶数
        // 只需要分最长的回文是奇数还是偶数，不管是奇是偶，都能执行到！

        // 最大回文子串是奇数 bab
        for (int i = 0; i < array.length; i++) {
            int left = i;
            int right = i;
            while (array[left]==array[right]){
                if ( right-left+1 > maxLen ){
                    maxLen = right-left+1;
                    maxLeft = left;
                    maxright = right;
                }
                if(left-1>=0 && right+1<array.length){
                    left--;
                    right++;
                }else {
                    break;
                }

            }
        }



        // 最大回文子串是偶数 baab
        for (int i=0,j=1; i<array.length && j<array.length; i++,j++) {
            int left = i;
            int right = j;
            while ( array[left]==array[right] ){
                if (right-left+1 > maxLen ){
                    maxLen = right-left+1;
                    maxLeft = left;
                    maxright = right;
                }
                if(left-1>=0 && right+1<array.length){
                    left--;
                    right++;
                }else {
                    break;
                }
            }
        }
        return s.substring(maxLeft, maxright+1);
    }

    public static void main(String[] args) {
        String s = "ccc";
        String res = longestPalindrome(s);
        System.out.println(res);
    }

}













// 动态规划：dp[i][j]表示区间【i， j】是否是回文子串
// 遇到问题：其依赖的子方向是左下，故两个for循环的遍历顺序应该改变：
// 1.列是外循环，行是内循环：先遍历列，再遍历行。正常遍历
// 2.行是外循环，列是内循环：先遍历行 但从下往上，再遍历列，从左往右
// // 特殊例子：
// if (s == null || s.length() == 1) {
//     return s;
// }

// char[] charArray = s.toCharArray();
// // dp[i][j]数组的定义：表示区间[i，j]的最长回文子串
// int[][] dp = new int[s.length()][s.length()];

// //  初始化：每个单独的字母都是回文串
// for (int i = 0; i < s.length(); i++) {
//     dp[i][i] = 1;
// }
// int maxLen = 1;
// String maxStr = Character.toString(charArray[0]);

// // 递推公式
// for (int i = 0; i < s.length(); i++) {
//     for (int j = i+1; j < s.length(); j++) {
//         if (charArray[i] == charArray[j]){
//             dp[i][j] = dp[i+1][j-1] + 2;
//         }
//         if (dp[i][j] > maxLen){
//             maxLen = dp[i][j];
//             maxStr = s.substring(i, j+1);
//             //substring API方法的参数说明：beginIndex -- 起始索引（包括）, 索引从 0 开始。endIndex -- 结束索引（不包括）。
//         }
//     }
// }
// return maxStr;






// // 把该题 转变为 最长重复子数组。解决90%的测试用例。但是还是没通过！在这个字符串上出错aacabdkacaa。

// public String longestPalindrome(String s) {
//     char[] array2 = s.toCharArray();
//     // 反转字符串
//     String revert = new StringBuffer(s).reverse().toString();
//     char[] array1 = revert.toCharArray();

//     // 最长的长度、以及对应的字符串
//     int maxlen = 0;
//     String maxStr = "";

//     // 定义dp数组：以i j为结尾的子串的最长重复连续子序列的长度
//     int[][] dp = new int[s.length()][s.length()];

//     for (int i = 0; i < s.length(); i++) {
//         for (int j = 0; j < s.length(); j++) {
//             if (array1[i] == array2[j]){
//                 // 两数相等
//                 if (i==0 || j==0){  // 单独处理第1行和第1列
//                     dp[i][j] = 1;
//                 }else {
//                     dp[i][j] =  dp[i-1][j-1] + 1;
//                 }
//             }else{
//                 // 两数 不相等
//                 dp[i][j] = 0;
//             }
//             if (dp[i][j] > maxlen){
//                 maxlen = dp[i][j];
//                 int begin =  j-maxlen+1;
//                 int end = j-maxlen+1+maxlen;
//                 maxStr = s.substring(begin, end);
//             }
//         }
//     }
//     return maxStr;
// }