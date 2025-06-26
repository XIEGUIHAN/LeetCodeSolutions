package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//时间复杂度为 O(n)  不一定代表一个for循环！！！！
public class findDuplicates {
    public static List<Integer> findDuplicatesMethod(int[] nums) {
        ArrayList<Integer> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            // while是重点，在有限次数内，依然是O(n)时间复杂度
            while ( nums[i] != nums[ nums[i]-1 ] ){
                swap( nums, i, nums[i]-1 );
            }
        }

        // 遍历，拿到不是在自己位置的数，就是出现两次的数
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] != (i+1) ){
                res.add(nums[i]);
            }
        }

        return res;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicatesMethod(nums);
        System.out.println(duplicates);
    }
}
