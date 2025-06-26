package leetcode.scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test123 {
    public static void main(String[] args) {

//        ArrayList<Integer> arr = new ArrayList<>();
//
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//
//        for (Integer i : arr) {
//
//        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(10,20);

//        for (Integer i : map.keySet()) {
//            System.out.println(i);
//        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.println(item);
        }


    }
}
