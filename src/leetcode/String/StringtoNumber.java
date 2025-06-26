package leetcode.String;

public class StringtoNumber {
    public static int myStringtoNumber(String s) {
        int res = 0;
        int sign = 1;         // 默认正数
        boolean hasSign = false; // 标记是否已经处理过符号
        boolean Numing = false; // 标记是否正在处理数字

        //转化为字符数组
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            // 记死了：break+switch+case+default。每个语句都必须加break，否则会向下穿透。
            switch (c){
                case '+':   // 每个case后面都必须带 break！！
                    if (hasSign)
                        return res * sign; // 如果符号已经处理过，直接返回
                    sign = 1;                 // 正号
                    hasSign = true;
                    break;

                case '-':
                    if (hasSign)
                        return res * sign; // 如果符号已经处理过，直接返回
                    sign = -1;                 // 正号
                    hasSign = true;
                    break;

                case ' ':
                    if (Numing || hasSign) // 如果在数字/符号后跟空格，直接返回
                        return res * sign;
                    break;

                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    int digit = c - '0';    // 将字符转为对应的数字
                    res = res*10 + digit;

                    hasSign = true; // 一旦开始处理数字，符号部分就结束了，后面就算出现符号也不处理了。
                    Numing = true;
                    break;

                default:    //default只有在case匹配失败的时候才会执行。default默认放在最后。
                    // 遇到非数字或符号字符，直接结束转换
                    return res * sign;
            }
        }
        return res * sign;

    }

    public static void main(String[] args) {
        String s = "1 1-42";
        int i = myStringtoNumber(s);
        System.out.println(i);
    }
}
