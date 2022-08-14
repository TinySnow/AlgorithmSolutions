package leetcode.official;

import necessary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question94 {
    /**
     * 简单递归版本
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // 边界判断
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private static void recursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        recursion(root.left, result);
        result.add(root.val);
        recursion(root.right, result);
    }

    /**
     * 别人的迭代版本
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
