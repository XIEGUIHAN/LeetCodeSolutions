package leetcode.exam;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.List;

public class beautifulNumber {

    //先找出 n以内的 所有质数
    static ArrayList<Integer> zhishuList = new ArrayList<>();
    public static ArrayList<Integer> zhishuNumber(int n){

        zhishuList.add(2);
        for (int i = 2; i <= n-1; i++) {
            int index = 0;
            for (int j = 2; j < n-1; j++) {
                if( i%j == 0 ){
                    break;
                }else {
                    index++;
                }
                if (index == i-2){
                    zhishuList.add(i);
                }
            }
        }
        return zhishuList;
    }

    public static int method(int n){
        int res = 0;
        for (int i = 2; i <= n; i++) {
            for (Integer integer : zhishuList) {
                if (i % integer == 0 && integer*integer>= i){
                    res++;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        ArrayList<Integer> integers = zhishuNumber(10);
        System.out.println(integers);

        int method = method(10);
        System.out.println(method);

    }
}
