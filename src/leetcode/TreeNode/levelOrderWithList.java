package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// BFS 主体架构是不变的。 要记录每一层有多少个元素：当前高度数heigh，当前高度有多少个元素cur_height_number
// 使用到的数据结构是：一个队列，两个数组(大数组，临时变量小数组)。放入队列的逻辑是不变的。
public class levelOrderWithList {
    public List<List<Integer>> levelOrderWithListMethod(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            // 他是这样的：一次性把每一级存入队列。然后记录下此时队列的总数。然后for循环执行BFS。因为已经记录了上一次的队列的总数，
            // 所以不再畏惧 某一层的结点还没出完，下一层的结点就进来了。for循环完毕意味着上一层的所有元素已出队！那么此时队列的总数就是下一层的所有元素了。

            //当队列不为空的时候：
            //  求当前队列的长度 s
            //  for依次从队列中取 s 个元素进行拓展，然后进入下一次迭代。

            //当下一次迭代开始时，队列的总数就是下一层的所有元素了，又可以进行上述的操作
            int n = queue.size();  // 保存层级的结果
            List<Integer> level = new ArrayList<>(); // 保存层级的结果
            for (int i = 0; i < n; i++) {  // 保存层级的结果
                TreeNode node = queue.poll();
                level.add(node.val);  // 保存层级的结果
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level); // 保存层级的结果
        }

        return res;
    }
}
