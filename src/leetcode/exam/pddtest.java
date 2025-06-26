package leetcode.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.awt.SystemColor.text;

public class pddtest {
    public static String pdd(String s){
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        // 初始化
        map.put(1, 0);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1'){
                map.put(1, map.get(1)+1);
            }
            if (charArray[i] == '0'){
                map.put(1, 0);
            }
            if (map.get(1) == 9 && charArray[i+1] != '1'){
                return "lucky";
            }
        }

        return "unlucky";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();;
//        int number = 0;
//        ArrayList<Integer> list = new ArrayList();
//        number = sc.nextInt();
        while (group>0 && sc.hasNextInt()) { // 注意 while 处理多个 case
            int number = sc.nextInt();
            String text = sc.next();
            String pdd = pdd(text);
            System.out.println(pdd);
            group--;
        }
//        while (number>0){
//            list.add(sc.nextInt());
//            number--;
//        }
//        String string = list.toString();
//        System.out.println(list);
//        String s = "11110111110";
//        String pdd = pdd(text);
//        System.out.println(pdd);
    }
}
