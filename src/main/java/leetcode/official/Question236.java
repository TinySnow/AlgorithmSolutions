package leetcode.official;

import necessary.TreeNode;

public class Question236 {
    /**
     * 1. 递归，事实上，除了递归也想不出来更好的解法了。
     * <p>
     * 逻辑解释：
     * 向下递归遍历，分三种情况：
     * p，q 在异侧：每次遍历时可以认为左右子树已经得到结果，要么 null，要么找到 p 和 q
     *            而如果左子树和右子树都不为空，可以认为 p 和 q 在异侧（仔细想一下），此时正在遍历的结点
     *            即为所求的公共祖先 root 结点
     * p，q 在同侧：肯定一方为另一方的子树，并且不可能同时为子树，后者的话就属于异侧情况了
     *            而一方为子树，则左右子树中，肯定有一方为 null，有一方找到了 p 或者 q
     *            注意：一方为 null，另一方找到了 p 或者 q，说明 q 或者 p（剩下的那一个）没有找到
     *                 但是此时也不用找了，因为先找到的那个结点，肯定为祖先节点，而没有找到的那个结点
     *                 必定在该结点的子树中
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
