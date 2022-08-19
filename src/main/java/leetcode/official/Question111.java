package leetcode.official;

import necessary.TreeNode;

public class Question111 {
    /**
     * 别人写的，注意最后的条件 4
     * 递归比较好理解
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 注意，因为题中说明了，到最近的一个叶子节点
        // 故，如果一个结点，有一个子结点，但是另一个子结点为 null，则应该顺着存在的哪个子节点走
        // 所以这里的条件就是其中一个子节点为 null，则走向另一边，同时深度 +1
        // 而因为 left + right 是因为不确定哪一边没有，但是可以确定是绝对有一边没有的
        // 所以这里的两个相加其实只有一个有实际意义，另一个为 0
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
