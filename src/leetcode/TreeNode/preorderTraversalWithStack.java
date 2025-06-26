package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// 用栈来模拟递归
public class preorderTraversalWithStack {
    // 定义一个栈来模拟递归、数组来存储前序遍历的输出！
    Stack <TreeNode> stack = new Stack<>();
    List<Integer> preorderList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return preorderList;
        }
        stack.push(root);
        // 相同点----与层序遍历相似，但是层序遍历用的是 队列！
        while( !stack.isEmpty() ){
            TreeNode pop = stack.pop();
            preorderList.add(pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
        return preorderList;
    }
}
