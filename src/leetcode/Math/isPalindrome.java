package leetcode.Math;

public class isPalindrome {
    public static boolean isPalindrome(int x) {
        // 法一：转化为字符串来判断
//        String s = String.valueOf(x);
//        char[] charArray = s.toCharArray();
//        for (int i = 0,j = charArray.length-1; i < j; i++, j--) {
//            if (charArray[i] != charArray[j]){
//                return false;
//            }
//        }
//        return true;

        // 法二：数学计算
        // 取个位数
        if ( x<0 || (x%10 == 0&& x!=0) ){
            return false;
        }

        int revertNumber = 0;
        while ( x > revertNumber ){
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertNumber || x == revertNumber/10;
    }

    public static void main(String[] args) {
        int x = -121;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }
}
