package leetcode.sort;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class quick {
    public static void quickSort_NG(int[] testArr,int s, int e) {
        if(s >= e) {return;}
        int p = testArr[s];//p为上文中的num
        int l = s, r=e; //l为上文中的i，r为j
        while(l<r) {
            while(testArr[r] >= p && l<r) {r--;}
            while(testArr[l] <= p && l<r) {l++;}
            int temp = testArr[l];
            testArr[l] = testArr[r];
            testArr[r] = temp;

        }
        testArr[s] = testArr[l];
        testArr[l] = p;
        quickSort_NG(testArr,s,l-1);
        quickSort_NG(testArr,l+1,e);

    }
    public static void main(String[] args) {
        int[] testArr = {4,3,8,1,-1,2,5,4};
        quickSort_NG(testArr,0,testArr.length-1);
        for (int i : testArr) {System.out.print(i+" ");}
    }
}
