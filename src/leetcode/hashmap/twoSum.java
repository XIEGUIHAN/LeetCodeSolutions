package leetcode.hashmap;

import java.util.HashMap;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ( map.containsKey( target-nums[i] ) ){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put( nums[i], i );
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    //时间复杂度？空间是o(N)
}
