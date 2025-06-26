package leetcode.exam;
import java.util.Scanner;

public class Main {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        System.out.println("Enter an integer:"+s);
//        if (scanner.hasNextInt()) {
//            int num = scanner.nextInt();
//            System.out.println("You entered: " + num);
//        } else {
//            System.out.println("Invalid input (not an integer)");
//        }
        scanner.nextLine(); // 清除缓冲区

//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int group = in.nextInt();
//            for (int i = 0; i < group; i++) {
//                int day = in.nextInt();
//                int day_max_time = in.nextInt();
//
//                int workTime = 0;
//                for (int j = 0; j < day; j++) {
//                    workTime += in.nextInt();
//                }
//                if (workTime <= day*day_max_time){
//                    System.out.println("YES");
//                }else {
//                    System.out.println("NO");
//                }
//            }
//        }
    }

}
