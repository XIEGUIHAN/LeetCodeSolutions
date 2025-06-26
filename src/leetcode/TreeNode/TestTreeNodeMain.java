package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TestTreeNodeMain {
    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;


//        // DFS
//        inorderTraversal intraversal = new inorderTraversal();
//        ArrayList<Integer> result = intraversal.inorderTraversalMethod(root);
//        for (Integer i : result) {
//            System.out.print(i + " ");
//        }

        // 用栈模拟递归栈--前序遍历二叉树
//        preorderTraversalWithStack pretra = new preorderTraversalWithStack();
//        List<Integer> integers = pretra.preorderTraversal(root);
//        System.out.println(integers);

        //用栈模拟递归--后续遍历
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.right = node1;
//        node1.left = node2;
//        postorderTraversal po = new postorderTraversal();
//        po.postorderTraversal(root);
//        inorderTraversal in = new inorderTraversal();
//        in.inorderTraversalMethod(root);


        //BFS
//        levelOrder le = new levelOrder();
//        le.levelOrder(root);


//        //BFS-LIST
        levelTraversal lt = new levelTraversal();
        List<List<Integer>> lists = lt.levelTraversalMethod(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


//        //二叉树的最大深度
//        maxDepth md = new maxDepth();
//        int depth = md.maxDepthMethod(root);
//        System.out.println(depth);

        // 翻转二叉树
//        TreeNode root = new TreeNode(2);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        invertTree invertTree = new invertTree();
//        invertTree.invertTreeMethod(root);
//        //BFS
//        levelOrder le = new levelOrder();
//        le.levelOrder(root);


        // 判断对称二叉树  不会写啊，看不懂
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(2);
//        root.left = node1;
//        root.right = node2;
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(2);
//        node1.left = node3;
//        node1.right = null;
//        node2.left = node4;
//        isSymmetric is = new isSymmetric();
//        boolean symmetric = is.isSymmetric(root);
//        System.out.println(symmetric);


        // 236.二叉树的最近公共祖先
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        root.left = node1;
//        root.right = node2;
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(0);
//        TreeNode node6 = new TreeNode(8);
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(4);
//        node4.left = node7;
//        node4.right = node8;
//
//        lowestCommonAncestor lc = new lowestCommonAncestor();
//        TreeNode treeNode = lc.lowestCommonAncestorMethod(root, node1, node8);  // root 5，4
//        System.out.println(treeNode.val);


        // 二叉树的直径
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
//        root.left= node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        diameterOfBinaryTree dia = new diameterOfBinaryTree();
//        int i = dia.diameterOfBinaryTree(root);
//        System.out.println(i);


        // 二叉树展开为链表
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        node1.left = node3;
//        node1.right = node4;
//        node2.right = node5;
//
//        flatten.flatten(root);
//        inorderTraversal intraversal = new inorderTraversal();
//        ArrayList<Integer> result = intraversal.inorderTraversalMethod(root);
//        for (Integer i : result) {
//            System.out.print(i + " ");
//        }


    }
}
