package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] map = new int[1002];
        Set<Integer> set = new HashSet<>();


        for (int i = 0; i < nums1.length; i++) {
            if (map[nums1[i]] == 0){
                map[nums1[i]] = 1;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map[nums2[i]] == 1){
                set.add(nums2[i]);
            }
        }

        // 手动遍历填充！
        int[] res = new int[set.size()];

        // 怎么遍历拿到set里面的数字？？？？？？
        int j = 0;
        for (Integer s : set) {
            res[j++] = s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);

    }
}
