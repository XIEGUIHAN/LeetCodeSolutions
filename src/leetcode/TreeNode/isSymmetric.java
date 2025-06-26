package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayList;


// 中序遍历
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }
    public boolean check( TreeNode p, TreeNode q ){
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        if (check(p.left , q.right) && check(p.right , q.left)){
            return true;
        }else {
            return false;
        }
    }
}
