package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

//1.在遍历每个根节点的时候，左树最大长度 加上 右树最大长度 等于 当前节点的最大直径。
//2.我们返回给父节点的长度则是 左树 和 右树 中 最大长度 的那个。
//3.但是我们并不知道 当前节点的最大直径 是不是整棵树的最大直径，返回的值也不是当前节点的最大直径，所以我们没法通过返回值的求出最大直径,那么我们应该定义一个成员变量，比较每一个根节点的最大直径。

public class diameterOfBinaryTree {
    // 这里的递归之所以必须分开，是因为，最终结果必须return 最大直径回去maxdiameter，而每层节点返回给父节点的时候，却要返回左/右的最大长度。所以两个返回值不一样。
    int maxdiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxdiameter;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        maxdiameter = Math.max(maxdiameter, L+R);
        return Math.max(L,R) + 1;
    }

}
