package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.*;

public class zigzagLevelOrder {
    Deque<TreeNode> queue = new ArrayDeque();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null){
            return res;
        }
        queue.addLast(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int levelSize = queue.size(); // 固定当前层的节点数
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.removeFirst();
                if (res.size() % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        zigzagLevelOrder zig = new zigzagLevelOrder();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = null;
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        node1.left = node3;
        node1.right = node4;
        node1.right = node5;
        node2.right = node6;
        List<List<Integer>> lists = zig.zigzagLevelOrder(root);
        System.out.println(lists);

    }

}
