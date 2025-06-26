package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(nums, 0);
        return res;
    }

    void backtracking(int[] nums, int startIndex){
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        backtracking(nums, 0, res, path);
//        res.add(new ArrayList<>());
//        return res;
//    }
//    public static void backtracking(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> path){
//        // 终止条件
////        if (startIndex > nums.length){
////            return;
////        }
//        for (int i = startIndex; i < nums.length; i++) {
//            path.add(nums[i]);
//            res.add(new ArrayList<>(path));
//            backtracking(nums, i+1, res, path);
//            path.remove( path.size()-1 );
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets subsets1 = new subsets();
        List<List<Integer>> subsets = subsets1.subsets(nums);
        System.out.println(subsets);
    }
}
