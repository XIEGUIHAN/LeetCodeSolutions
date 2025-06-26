package leetcode.array;

import javax.swing.plaf.SliderUI;

//209. 长度最小的子数组
public class minSubArrayLen {
    // 滑动窗口版
    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int len = nums.length;
        int res = nums.length;
        boolean flag = false;

        int sum = 0;
        for (int fast = 0; fast < len; fast++) {
            if (sum < target){
                sum += nums[fast];
                while (sum >= target){
                    flag = true;
                    res = Math.min( res, fast-slow+1 );
                    sum = sum - nums[slow];
                    slow++;
                }
            }
        }
        if (flag == false){
            res = 0;
        }

        return res;
    }





    // 暴力解法
//    public static int minSubArrayLen(int target, int[] nums) {
//        int result = nums.length;
//        boolean flag = false;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum = sum + nums[j];
//                if (sum >= target){
//                    result = Math.min(result, j-i+1);
//                    flag = true;
//                    break;
//                }
//            }
//        }
//        if (flag == false){
//            result = 0;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int i = minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
