package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;
import org.omg.CORBA.IRObject;

// 112.路径总和---从叶子节点到根节点！那就是从下往上思考呀！

public class hasPathSum {
    int ret = 0;
    int times = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum);
        return times==0?false:true;
    }
    public void DFS(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        ret = ret + root.val;
        if (root.left == null && root.right == null){
            // 到了叶子节点，需要收获结果了
            if (ret == targetSum){
                times = times + 1;
            }
        }

        DFS(root.left, targetSum);
        DFS(root.right, targetSum);

        ret = ret - root.val;

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

        hasPathSum has = new hasPathSum();
        boolean b = has.hasPathSum(root, 9);
        System.out.println(b);
    }
}
