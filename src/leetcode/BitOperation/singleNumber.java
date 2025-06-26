package leetcode.BitOperation;


import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static int singleNumberMethod(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int i = singleNumberMethod(nums);
        System.out.println(i);
    }
}
