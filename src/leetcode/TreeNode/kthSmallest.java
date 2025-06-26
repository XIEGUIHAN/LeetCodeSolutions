package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;

// 230.二叉搜索树中第K小的元素---中序遍历秒了

public class kthSmallest {
    ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        DFS(root, list);
        return list.get(k);

    }
    public void DFS(TreeNode node, ArrayList<Integer> list){
        if (node == null){
            return;
        }
        DFS(node.left, list);
        list.add(node.val);
        DFS(node.right, list);
    }
}
