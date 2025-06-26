package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

// 437.路径总和III------需要递归 再 递归

public class pathSumIII {
    int times = 0;
    int sum = 0;
    public int pathSum(TreeNode root, int targetSum) {

        DFS(root, targetSum);

        return times;
    }
    public int DFS(TreeNode root, int targetSum){
        int sum = 0;
        if (root == null){
            return 0;
        }


        DFS(root.left, targetSum);
        DFS(root.right, targetSum);

//        if (targetSum == )
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        pathSumIII pa = new pathSumIII();
        int times = pa.pathSum(root, 8);
        System.out.println(times);

    }


}
