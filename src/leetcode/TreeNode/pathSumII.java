package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSumII {
    int ret = 0;
    int times = 0;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum);
        return res;
    }
    public void DFS(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        path.add(root.val);
        ret = ret + root.val;
        if (root.left == null && root.right == null){
            // 到了叶子节点，需要收获结果了
            if (ret == targetSum){
                times = times + 1;
                res.add( new ArrayList<>(path) );
            }
        }

        DFS(root.left, targetSum);
        DFS(root.right, targetSum);

        ret = ret - root.val;
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        pathSumII path = new pathSumII();
        List<List<Integer>> lists = path.pathSum(root, 9);
        System.out.println(lists);

    }
}
