package leetcode.hashmap;

import java.util.HashSet;

public class longestConsecutive {
    public static int longestConsecutiveMethod(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        for (Integer num : set) {
            // 找不到num的上一个数，则计算以这个数为开头的连续数能达到多少位；若找得到就过。
            if( !set.contains(num-1) ){
                int cur = num;
                int numLong = 0;

                while ( set.contains(cur+1) ){
                    cur++;
                    numLong++;
                    longestStreak = Math.max( numLong, longestStreak );
                }
            }
        }
        return longestStreak;
    }


    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,4,2};
        int res = longestConsecutiveMethod(nums);
    }
}
