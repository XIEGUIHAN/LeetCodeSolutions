package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.TreeNode.defineTreeNode.TreeNode;
// 中序遍历： 左中右
//public class inorderTraversal {
//    public ArrayList<Integer> inorderTraversalMethod(TreeNode root){
//        ArrayList<Integer> result = new ArrayList<>();
//        // 入口方法
//        inorder(root, result);
//        return result;
//    }
//    // 递归方法
//    void inorder(TreeNode root, ArrayList<Integer> result){
//        if(root == null){
//            return;
//        }
//        inorder(root.left, result);
//        result.add(root.val);
//        inorder(root.right, result);
//    }
//}


// 递归法
public class inorderTraversal {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> inorderTraversalMethod(TreeNode root){
        if (root == null) return null;
        inorderTraversalMethod(root.left);
        result.add(root.val);
        inorderTraversalMethod(root.right);
        return result;
    }
}


// 用栈模拟递归--中序遍历     需要多一个 cur指针
//public class inorderTraversal {
//    public void inorderTraversalMethod(TreeNode root){
//        if (root == null) {
//            return;
//        }
//        TreeNode cur = root;
//        Stack<TreeNode> stack = new Stack();
//
//        while (!stack.isEmpty() || cur != null){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            TreeNode pop = stack.pop();
//            System.out.println(pop.val);
//            if(pop.right != null){
//                cur = pop.right;
//            }
//        }
//    }
//}

