package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;

//  【DFS + 上下界】 验证是否二叉搜索树
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return  DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    public boolean DFS(TreeNode node, long lower, long upper) {
        if (node == null){
            return true;
        }
        if (node.val >= upper || node.val <= lower){
            return false;
        }
        return DFS(node.left, lower, node.val) && DFS(node.right, node.val, upper);
    }
}



//  中序遍历 + List 验证是否二叉搜索树，空间复杂度O(N);

//public class isValidBST {
//    public boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        DFS(root, list);
//        for (int i = 0; i < list.size(); i++) {
//            if (i+1<list.size() && list.get(i) > list.get(i+1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void DFS(TreeNode root, ArrayList<Integer> list) {
//        if (root == null){
//            return;
//        }
//        DFS(root.left, list);
//        list.add(root.val);
//        DFS(root.right, list);
//    }
//
//}
