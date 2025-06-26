package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    //遍历【排序】后的数组：
    //若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
    //对于重复元素：跳过，避免出现重复解
    //令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
    //当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
    //若和大于 0，说明 nums[R] 太大，R 左移
    //若和小于 0，说明 nums[L] 太小，L 右移

    public static List<List<Integer>> threeSum(int[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new ArrayList<>();
        //数组的长度
        int len = nums.length;

        // 数组排序
        Arrays.sort(nums);
        //如果第一个数就大于0，后面就不用遍历了；
        if (nums[0] > 0){
            return res;
        }
        // 遍历排序后的数组
        for (int i = 0; i < len; i++) {
            int l = i+1;
            int r = len-1;
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while (l<r){
                //计算 三数之和
                int sum = nums[i] + nums[l] + nums[r];
                if (sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    while (l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    while (l<r && nums[l] == nums[l+1]){
                        l++;
                    }
                    r--;
                    l++;
                } else if (sum > 0){// 若和大于 0，说明 nums[R] 太大，R 左移
                    while (l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    r--;
                } else{//若和小于 0，说明 nums[L] 太小，L 右移
                    while (l<r && nums[l] == nums[l+1]){
                        l++;
                    }
                    l++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
