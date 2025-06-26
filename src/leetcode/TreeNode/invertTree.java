package leetcode.TreeNode;
import apple.laf.JRSUIUtils;
import leetcode.TreeNode.defineTreeNode.TreeNode;


public class invertTree {
    public TreeNode invertTreeMethod(TreeNode root){
        if(root == null){
            return null;
        }
        swapTreeNode( root );
        invertTreeMethod( root.left );
        invertTreeMethod( root.right );
        return root;
    }

    public void swapTreeNode( TreeNode root ){
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
