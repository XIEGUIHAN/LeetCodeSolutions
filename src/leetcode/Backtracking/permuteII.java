package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permuteII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteII permute = new permuteII();
        List<List<Integer>> lists = permute.permuteUnique(nums);
        System.out.println(lists);
    }
}
