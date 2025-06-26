package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;

public class isSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){}
        if (p == null && q != null || p != null && q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        boolean sameTree = isSameTree(p.left, q.left);
        boolean sameTree1 = isSameTree(p.left, q.left);

        if (sameTree == true && sameTree1 == true){
            return true;
        }else {
            return false;
        }

    }


    public static void main(String[] args) {
        // 创建二叉树
        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        p.left = node1;

        TreeNode q = new TreeNode(1);
        TreeNode qnode1 = null;
        TreeNode qnode2 = new TreeNode(3);
        q.left = qnode1;
        q.right = qnode2;

        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }
}






// 用DFS + list遍历
//public class isSameTree {
//    public static boolean isSameTree(TreeNode p, TreeNode q) {
//        ArrayList<Integer> l1 = new ArrayList<>();
//        ArrayList<Integer> l2 = new ArrayList<>();
//        DFS(p, l1);
//        DFS(q, l2);
//
//        for (int i = 0,j=0; i<l1.size() && j<l2.size(); i++,j++) {  // 不能用逗号！
//            Integer val1 = l1.get(i);
//            Integer val2 = l2.get(i);
//            if (val1 == null && val2 == null) {
//                continue; // 两个都是 null，相等
//            }
//            if (val1 == null || val2 == null) {
//                return false; // 一个为 null，另一个不是
//            }
//            if (!val1.equals(val2)) { // 比较整数值
//                return false;
//            }
//        }
//
//        return true;
//    }
//    public static void DFS(TreeNode root, ArrayList<Integer> list) {
//        if (root == null){
//            list.add(Integer.MAX_VALUE);
//            return;
//        }
//        list.add(root.val);
//        DFS(root.left, list);
//        DFS(root.right,list);
//    }
//
//
//    public static void main(String[] args) {
//        // 创建二叉树
//        TreeNode p = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
//        p.left = node1;
//
//        TreeNode q = new TreeNode(1);
//        TreeNode qnode1 = null;
//        TreeNode qnode2 = new TreeNode(3);
//        q.left = qnode1;
//        q.right = qnode2;
//
//        boolean sameTree = isSameTree(p, q);
//        System.out.println(sameTree);
//    }
//}
