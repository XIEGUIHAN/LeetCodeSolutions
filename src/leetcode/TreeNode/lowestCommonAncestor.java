package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;
import java.util.*;

// 用递归的方法
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestorMethod(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null) return null;
        if (root == p || root == q) return root;

        // 当前节点不是p也不是q，那么继续往下面寻找。
        // 因为需要从底往上判断，所以是回溯，要用后序遍历。
        TreeNode left = lowestCommonAncestorMethod( root.left, p, q );
        TreeNode right = lowestCommonAncestorMethod( root.right, p, q );

        // 回溯的，从底下叶子节点开始的统计结果：得到左右结果后，中间节点来做判断
        if (left != null && right != null)  return root;
        if (left != null && right == null)  return left;
        if (left == null && right != null)  return right;
        else return null;
    }
}



// 用哈希表的方法
//1.从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
//2.从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
//3.同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点。
//public class lowestCommonAncestor {
//    static HashMap<Integer, TreeNode> map = new HashMap<>();
//    static ArrayList<TreeNode> Ancestorlist = new ArrayList<>();
//
//    // 步骤一：从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针
//    public static void DFS( TreeNode root ){
//        if (root.left != null){
//            //进入左子树的递归前：把左子树放进栈前，先把自己和子节点放进hashmap中
//            map.put(root.left.val, root);
//            DFS(root.left);
//        }
//        if (root.right != null){
//            //进入左子树的递归前：把左子树放进栈前，先把自己和子节点放进hashmap中
//            map.put(root.right.val, root);
//            DFS(root.right);
//        }
//    }
//
//    //步骤二：在哈希表中，p、q节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
//    public TreeNode lowestCommonAncestorMethod(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {return null;}
//        if (p == null) {return q;}
//        if (q == null) {return p;}
//
//        map.put(root.val, root);
//        DFS(root);
//        // p指针一直寻找祖先到根节点，注意p自己也要放进去
//        Ancestorlist.add(p);
//        while (map.get(p.val) != p){    // 自己的祖先==自己，说明已经到了 根节点
//            Ancestorlist.add(map.get(p.val));  // 添加祖先
//            p = map.get(p.val); //移动到祖先的位置
//        }
//        // q指针也一直寻找祖先到根节点，但是要和p指针对比，如果碰到一样的了就是最近的祖先了！
//        while (map.get(q.val) != q){ // 自己的祖先==自己，说明已经到了 根节点
//            if(Ancestorlist.contains(q)){
//                break;
//                // 第一个相等的就是最近祖先了
//            }
//            q = map.get(q.val); //移动到祖先的位置
//        }
//
//        return q;
//    }
//}