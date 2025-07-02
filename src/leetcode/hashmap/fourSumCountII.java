package leetcode.hashmap;

// 454. 四数相加 II 【分治法：两个两个一组，用哈希表！】

import java.util.HashMap;

public class fourSumCountII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                int sum1 = i1 + i2;
                map.put(sum1, map.getOrDefault(sum1,0)+1);  //重点！
            }
        }

        for (int i3 : nums3) {
            for (int i4 : nums4) {
                int sum2 = i3 + i4;
                if (map.containsKey( -sum2 )){
                    res = res + map.get(-sum2);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int [] nums1 = {-1,-1};
        int [] nums2 = {-1,1};
        int [] nums3 = {-1,1};
        int [] nums4 = {1,-1};
        int i = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i);
    }
}
