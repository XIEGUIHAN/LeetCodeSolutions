package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// 【二刷】77.组合

public class combine {
    // 定义容器
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        trackbacking(1, n, k);
        return res;
    }

    void trackbacking(int startIndex, int n, int k){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(startIndex);
            trackbacking(startIndex++, n, k);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        combine c = new combine();
        List<List<Integer>> result = c.combine(4, 2);
        System.out.println(result);
    }
}













//public class combine {
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//
//        DFS(res, path, 1, n, k);
//        return res;
//    }
//
//    void DFS( List<List<Integer>> res, List<Integer> path, int startIndex ,int n, int k){
//
//        // 终止条件
//        if(path.size() == k){
//            res.add( new ArrayList<>(path));
//            return;
//        }
//
//
//        for (int i = startIndex; i <= n; i++) {
//            path.add(i);
//            DFS(res, path, i+1, n, k);
//            path.remove(path.size()-1);
//            startIndex--;
//        }
//    }
//
//    public static void main(String[] args) {
//        combine c = new combine();
//        List<List<Integer>> result = c.combine(4, 2);
//        System.out.println(result);
//    }
//}
