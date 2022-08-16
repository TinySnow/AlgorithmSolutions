package leetcode.official;

import necessary.TreeNode;

public class Question226 {
    /**
     * 最终选择：递归
     * <p>
     * 1. 递归，思路清晰
     * 2. 迭代，其实也就是手动维护一个 Stack，跟 1 差不多
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
    }
}
