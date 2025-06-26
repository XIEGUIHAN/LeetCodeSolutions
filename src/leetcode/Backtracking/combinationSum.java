package leetcode.Backtracking;

import java.util.*;

// 39.【二刷】组合总和

public class combinationSum {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtracking(candidates, target, 0, 0);
        return res;
    }

    void backtracking(int[] candidates, int target, int sum, int startIndex ){
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, target, sum, i);
            path.remove(path.size()-1);
            sum = sum - candidates[i];
        }
    }

























    
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<Integer> path = new LinkedList<>(); // 大结果容器
//        List<List<Integer>> result = new ArrayList<>(); // 小路径容器
//        Arrays.sort(candidates); // 先进行排序
//        int sum = 0;
//        backTracking(candidates, target, sum, path, result, 0);
//        return result;
//    }
//
//    public static void backTracking(int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> result, int startIndex){
//        if (sum == target){
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++) {
//            // 剪枝操作，终止遍历
//            if (sum + candidates[i] > target) break;
//            path.add(candidates[i]);
//            sum = sum + candidates[i];
//            backTracking(candidates, target, sum, path, result, i);
//            path.remove(path.size() - 1);
//            sum = sum - candidates[i];
//        }
//    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum combinationSum = new combinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        System.out.println(lists);
    }
    
}
