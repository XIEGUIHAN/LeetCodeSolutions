package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

// 124.二叉树中的最大路径和----可以从下往上思考！

public class maxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        DFS(root);
        return maxSum;
    }
    public int DFS(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = DFS(root.left);
        int rightSum = DFS(root.right);
        if (root.val > maxSum){
            maxSum = root.val;
        }
        if (leftSum+root.val > maxSum){
            maxSum = leftSum+root.val;
        }
        if (root.val+rightSum > maxSum){
            maxSum = root.val+rightSum;
        }
        if (leftSum+ root.val +rightSum > maxSum){
            maxSum = leftSum+ root.val +rightSum;
        }

        return Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.right = node4;

        maxPathSum mx = new maxPathSum();
        int res = mx.maxPathSum(root);
        System.out.println(res);

    }
}
