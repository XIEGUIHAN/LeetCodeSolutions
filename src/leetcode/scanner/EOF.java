package leetcode.scanner;

import java.util.Scanner;

public class EOF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) { // 检测是否还有下一个整数
            int a = sc.nextInt();
            String b = sc.next();
            System.out.println(a + b);
        }
    }
}
// 1. sc.hasNextInt()相当于监听器。监听当前的输入是否是整数。是则返回true。
//      但是并不是每次输入都会判断，它只会在需要判断的时候，才会判断。并且是不占用空间的。
// 2. 读取至文件末尾为止（EOF）通常是指输入流被关闭。系统会关闭或者crol+d，并不少回车！
// 3. 你得清楚有acm模式有多少种表示输入结束的方法。1.EOF系统自己处理关闭 2.需程序员控制结束，主要是利用if和while和break让代码走到程序末尾就能自动结束，而不是靠什么Scanner api(不是靠hasNextInt)。 3.报错自动结束：如期待输入数字却接收到字符串
//    示例二：输入cycle的值，然后while（cycle>0）{ cycle--;)；输入row然后for(int i=0; i<row; i++){}也可。
// 4. acm的输入输出有时候是不准确的！如下！需要自己脑补转换！
// 而不是，acm配图上的输入输出有点骗人！
// 输入：  1 2
//        3 4
//        5 6
// 输出：  3
//        7
//        11

// 上面的输入输出需要转换成这样：实际的情况是这样的：但其实是正确的符合题意的！
//输入：1 2
//输出：3
//输入：3 4
//输出：7
//输入：5
//     6
//输出：11

// 5.要求输入二维数组，因为后续肯定要用到的嘛，所以可以定义一个int[][]或者arraylist来接输入的元素
//        int row = sc.nextInt();
//        int column = sc.nextInt();
//        int[][] array = new int[row][column];
//        for(int i=0; i<row; i++){
//            for(int j=0; j<column; j++){
//                array[i][j] = in.nextInt();


// 6. 字符串的输入！要做处理尽量使用char[]、char[][]
// String s = scanner.next();可以读取连续的字母输入，然后自动转为字符串string，但遇到空格或换行就会停止读取
// String s = scanner.nextLine()来读取完整的一行：包括空格！！回车就是第二行了就结束了。
// 【重点】：String line = scanner.nextLine();前面一定要加一行这个scanner.nextLine();！！！！写两次！！！（如果字符串前面需要输入数字，那么必须再加一行这个！）
// 【重点】scanner没有api支持读取单个字符！所以，想要实现读取每个字符存进字符数组，只能：先读取一整行string字符串，再用原生的charAt(i)读取每个字符，放进char[]数组中！
//输入例子：
//        3 4
//        abcd
//        efgh
//        ijkl
//输出例子：
//        lkji
//        hgfe
//        dcba
//注意：这里需要接收多个字符串，然后做变化，所以这里要定义字符数组了！！无法用string字符串了！
// 现在可以实现和上面的输出一摸一样了。因为先把字符存进数组里面了。然后再统一输出！
//        char[][] charArray = new char[row][column];
//        for (int i = 0; i < row; i++) {
//            String line = in.next();
//            for (int j = 0; j < column; j++) {
//                charArray[i][j] = line.charAt(j);


// 读取小数nextDouble()
//double n = scanner.nextDouble();



