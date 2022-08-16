package leetcode.official;

import necessary.TreeNode;

import java.util.Stack;

public class Question98 {
    /**
     * 最终选择：递归
     * <p>
     * 1. 递归，不过请记住，不能只比较左子结点，根结点，右子结点，因为可能会有这种情况
     *                      5
     *               2             3
     *           1       8     1        4
     * 在上述例子中，比较每个 左子结点，根结点，右子结点 都是正确的，但整体是错误的
     * 所以需要维护一个 min 和 max
     * 2. 迭代，迭代感觉非常麻烦，不写代码了
     * 3. 中序遍历，二叉搜索树中序遍历出来是有序的，可以据此判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recursion(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return recursion(root.left, min, root.val) && recursion(root.right, root.val, max);
    }

    /**
     * 贴一个没看懂的别人的迭代版本
     * @param root
     * @return
     */
    public boolean isValidBSTIterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
