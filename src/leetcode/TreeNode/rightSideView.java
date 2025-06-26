package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 199.二叉树的右视图

public class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root==null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNumber = queue.size();  // 固定当前层的节点数
            for (int i = 0; i < levelNumber; i++) {
                TreeNode poll = queue.poll();
                if (i == levelNumber-1){
                    res.add(poll.val);
                }
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }

        return res;
    }

}
