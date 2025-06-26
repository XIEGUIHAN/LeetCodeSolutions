package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;


// 递归的写法
public class maxDepth {
    int depth = 0;
    public int maxDepthMethod(TreeNode root){
        if (root == null){
            return 0;
        }
        depth = Math.max( maxDepthMethod(root.left), maxDepthMethod(root.right) ) + 1;
        return depth;
    }
}



//真正的递归，不需要写初始化变量。  初始化变量在叶子节点 return 0；这里。
//public int maxDepth(TreeNode root) {
//    if (root == null){
//        return 0;
//    }
//    return Math.max( maxDepth(root.left), maxDepth(root.right) ) + 1;
//}



//public class maxDepth {
//
//    public int method(TreeNode root){
//        if (root == null){return 0;}
//        int depth = 1;
//        ArrayList<Integer> list = new ArrayList();
//        // 入口方法
//        maxDepthMethod(root, depth, list);
//        int max = 1;
//        for (Integer i : list) {
//            max = Math.max(max,i);
//        }
//        return max;
//    }
//
//    void maxDepthMethod(TreeNode root, int depth, ArrayList list){
//        if (root == null){
//            depth --;
//            list.add(depth);
//            return;
//        }
//        depth ++;
//        maxDepthMethod(root.left, depth, list);
//        maxDepthMethod(root.right, depth, list);
//    }
//
//}
