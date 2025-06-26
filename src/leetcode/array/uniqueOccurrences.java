package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //再用一个hash表来判断是否有重复  or 排序来去重
        int[] count = new int[2001];
        for(int i = 0; i<arr.length; i++){
            count[ arr[i] ]++;
        }

        int[] index = new int[2000];
        for (int i = 0; i < count.length; i++) {
            // 巨恶心，需要判断真正的0和值为0的hash表。注意count[i]>0才记录！
            if (count[i] > 0) {
                index[ count[i] ]++;
            }
        }

        for (int j = 0; j < index.length; j++) {
            if (index[j] != 0){
                if (index[j] != 1){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        uniqueOccurrences uniqueOccurrences = new uniqueOccurrences();
        int[] arr = {1,2};
        boolean b = uniqueOccurrences.uniqueOccurrences(arr);
        System.out.println(b);
    }
}
