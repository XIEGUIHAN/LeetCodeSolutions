package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 46. 全排列---二刷
public class permute {

    // 定义容器
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 本题核心【used】数组
        boolean[] used = new boolean[nums.length];
        trackback(nums, used, path, res);
        return res;
    }

    void trackback(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]==true){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            trackback(nums, used, path, res);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute permute = new permute();
        List<List<Integer>> lists = permute.permute(nums);
        System.out.println(lists);
    }
}
























//public class permute {
//
//    static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
//    static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
//    static boolean[] used;
//    public static List<List<Integer>> permuteMethod(int[] nums) {
//
//        if (nums.length == 0){
//            return result;
//        }
//        used = new boolean[nums.length];
//        // 开始递归
//        recursive(nums);
//        return result;
//    }
//
//    public static void recursive(int[] nums){
//        // 终止条件
//        if (path.size() == nums.length){
//            result.add( new LinkedList<>(path) );
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] == true){
//                continue;
//            }
//            path.add(nums[i]);
//            used[i] = true;
//            recursive(nums);
//            used[i] = false;
//            path.removeLast();
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        List<List<Integer>> lists = permuteMethod(nums);
//        System.out.println(lists);
//    }
//
//}
