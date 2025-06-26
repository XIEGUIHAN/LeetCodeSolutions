package leetcode.exam;

import java.util.HashMap;
import java.util.Scanner;

public class examtwo {
    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int group = in.nextInt();
            for (int i = 0; i < group; i++) {

                int arrayLength = in.nextInt();
                HashMap<Integer, Integer> map = new HashMap(arrayLength);

                for (int j = 0; j < arrayLength; j++) {
                    int x = in.nextInt();
                    if (!map.containsKey(x)) {
                        map.put(x, 1);
                    } else {
                        //存在
                        map.put(x, map.get(x) + 1);
                    }
                }
//                // System.out.println(map);
//                map.forEach((key, value)-> {
//                    if (value > 1) {
//                        System.out.println(arrayLength - 2);
//                    }
//                });
//                System.out.println(arrayLength - 1);

                // 迭代值
                int d = 0;
                for (Integer value : map.values()) {
                    if (value > 1) {
                        d = 1;
                    }
                }

                if (d == 1){
                    System.out.println(arrayLength - 2);
                }else {
                    System.out.println(arrayLength - 1);
                }

            }
        }
    }
}

























