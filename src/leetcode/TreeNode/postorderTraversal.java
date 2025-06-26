package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

// 用栈来模拟后序遍历
public class postorderTraversal {
    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 后序遍历需要用2个栈
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        stack1.push(root);
        while (! stack1.isEmpty()){
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null){
                stack1.push(pop.left);
            }
            if (pop.right != null){
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(stack2.pop().val);
            System.out.println(stack2.pop().val);
        }
    }
}