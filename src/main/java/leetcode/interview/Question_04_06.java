package leetcode.interview;

import necessary.TreeNode;

public class Question_04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 特殊情况
        if (root == null || p == null) {
            return null;
        }
        // 如果根节点小于等于需求结点的值，说明该往右子树找，左子树是肯定没有答案的
        // 中序遍历（左根右）的直接后继，在根节点都大于需求节点时，是不可能在左子树的
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        // 如果找到了第一个该往左子树找的结点，我们尝试往左子树找，但也有可能该节点没有左子树
        TreeNode ans = inorderSuccessor(root.left, p);
        // 所以如果有左子树，继续递归，到没有左子树的结点，如果没有左子树，直接返回当前结点
        return ans == null ? root : ans;
    }
}
