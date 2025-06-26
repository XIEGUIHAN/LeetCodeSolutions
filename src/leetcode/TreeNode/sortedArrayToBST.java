package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;


public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 选择递归的话：就是题目中的示例
        //方法一：中序遍历，总是选择中间位置左边的数字作为根节点
        return structure(nums, 0, nums.length - 1);
    }
    public TreeNode structure( int[] nums, int left, int right ){
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(mid);

        root.left = structure(nums, 0, mid-1);
        root.right = structure(nums, mid+1, nums.length-1);

        return root;
    }
}
