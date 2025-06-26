package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NTreelevelOrder {
    public List<List<Integer>> levelOrder(NTreeNode root) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<NTreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            // 要提前把queue.size()算出来，因为随着子节点加入，会动态变化的！
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                NTreeNode pop = queue.pop();
                path.add(pop.val);
                for (NTreeNode child : pop.children) {
                    queue.add(child);
                }
            }
            res.add(new ArrayList<>(path));
            path.clear();
        }
        return res;
    }

}
