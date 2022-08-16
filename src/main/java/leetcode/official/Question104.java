package leetcode.official;

import necessary.TreeNode;

public class Question104 {
    /**
     * 最终解法：迭代
     * <p>
     * 1. 递归，此解法是别人的，很优雅
     * 2. 迭代，暂时没想出来好的解法，或许层次遍历可行，两个 Deque
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
