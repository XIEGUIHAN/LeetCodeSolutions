package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class flatten {
    public static void flatten(TreeNode root) {
        // 法一：DFS
        List<TreeNode> list = new ArrayList<>();
        DFS(root, list);
//        for (TreeNode treeNode : list) {
//            System.out.println(treeNode.val);
//        }
        TreeNode curr = root;
        for (int i = 1; i < list.size(); i++) {
            curr.left = null;
            curr.right = list.get(i);
            curr = curr.right;
        }

    }
    public static List<TreeNode> DFS(TreeNode root, List<TreeNode> list){
        if (root == null){
            return list;
        }
        list.add(root);
        DFS(root.left, list);
        DFS(root.right, list);
        return list;
    }

}
