package leetcode.official;

import necessary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question515 {
    /**
     * 最终选择：迭代
     * 1. 递归。递归有可能会出一些不好定位的 bug，而且不好维护当前层，需要额外的空间，所以此处不递归
     * 2. 迭代。
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            // 循环完当前层即可，即开始下一层
            while (size-- > 0) {
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
