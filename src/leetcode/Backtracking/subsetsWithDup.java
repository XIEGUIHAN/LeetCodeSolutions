package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        res.add(new ArrayList<>());
        backtracking(nums, 0, used);
        return res;
    }

    void backtracking(int[] nums, int startIndex, int[] used){
        for (int i = startIndex; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1] && used[i-1]==0)
                continue;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            used[i] = 1;
            backtracking(nums, i+1, used);
            path.remove(path.size()-1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup subsetsWithDup = new subsetsWithDup();
        List<List<Integer>> subsets = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(subsets);
    }


}
