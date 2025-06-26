package leetcode.TreeNode;
import leetcode.TreeNode.defineTreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class levelTraversal {
    public List<List<Integer>> levelTraversalMethod(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        // 队列用于对树的节点排序输出
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null){
            queue.add(root);
        }else{
            return null;
        }
        //思路：在每一层遍历开始前，先记录队列中的结点数量 n（也就是这一层的结点数量）

        // 想明白这个关系式就明白怎么写了：
        // 在进入迭代poll出元素之前的队列长度 = 某一层的所有节点数 = 队列中依次取n个元素出来 放新元素进去动作完成后 队列内剩余的长度

        //当队列不为空的时候：
        //  在poll之前 求当前队列的长度 s。
        //  for依次从队列中取 s 个元素进行拓展，然后进入下一次迭代。

        while ( !queue.isEmpty() ){
            // 要提前把queue.size()算出来，因为随着子节点加入，会动态变化的！！！！！！【重点】，不能直接for (int i = 0; i < queue.size(); i++) {}
            int current_size = queue.size();   //求当前队列的长度 s
            List<Integer> currentFloorList = new ArrayList<>();

            for (int i = 0; i < current_size; i++) {
                TreeNode poll = queue.poll();
                currentFloorList.add(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
            res.add(currentFloorList);
        }
        return res;
    }
}
