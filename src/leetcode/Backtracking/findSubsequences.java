package leetcode.Backtracking;

import java.util.*;

public class findSubsequences {
    // 定义容器
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    void backtracking(int[] nums, int startIndex){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if ( path.size()>=1 && nums[i] < path.get(path.size()-1) || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,3,2,1};
        findSubsequences findSubsequences = new findSubsequences();
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
        System.out.println(subsequences);
    }
}
