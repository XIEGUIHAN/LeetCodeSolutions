package leetcode.String;

// 415.字符串相加
// 字符串的处理 StringBuffer
// 原生的charAt(i),原生的字符串可以直接相加，也可以加字符。
// 字符串遍历字符：可以 str.length(); 不能str[0]，应该是str.chatAt(0);

public class addStrings {
    public static String addStrings(String num1, String num2) {

        String resString = "";
        String revertnum1 = "";
        String revertnum2 = "";
        String revertRes = "";
        // 反转字符串
        for (int i = num1.length()-1; i >=0 ; i--) {revertnum1 += num1.charAt(i);}
        for (int i = num2.length()-1; i >=0 ; i--) {revertnum2 += num2.charAt(i);}
        // 进位
        int add = 0;
        int i = 0;
        int j = 0;

        while (i<revertnum1.length() || j<revertnum2.length() || add == 1){
            int x = 0;
            if (i<revertnum1.length()){
                x = revertnum1.charAt(i)-'0';
            }
            int y = 0;
            if (j<revertnum2.length()){
                y = revertnum2.charAt(j)-'0';
            }
            int res = x + y + add;
            add = 0;  // 复位
            if (res >= 10){
                add++;  // 进位
                res = res % 10;
            }
            resString = resString + (char)(res+48);
            i++;
            j++;
        }
        for (int k = resString.length()-1; k >=0 ; k--) {revertRes += resString.charAt(k);}
        return revertRes;
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        String s = addStrings(num1, num2);
        System.out.println(s);

    }
}
