package leetcode.DynamicProgram;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestDynamicProgram {
    public static void main(String[] args) {

//        // 爬楼梯
//        climbStairs c = new climbStairs();
//        int res = c.climbStairsMethod(4);
//        System.out.println(res);

//        //最长递增子序列
//        lengthOfLIS los = new lengthOfLIS();
//        int[] array = {0,1,0,3,2,3};
//        //不加max的dp数组会变成这样：[1,2,1,2,2,3]
//
//        int res = los.lengthOfLISMethod(array);
//        System.out.println(res);

        //斐波那契数列
        fib f = new fib();
        int i = f.fibMethod(2);
        System.out.println(i);

    }
}
