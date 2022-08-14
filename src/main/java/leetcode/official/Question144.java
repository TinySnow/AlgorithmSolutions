package leetcode.official;

import necessary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question144 {
    public List<Integer> preorderTraversal(TreeNode root) {
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
        result.add(root.val);
        recursion(root.left, result);
        recursion(root.right, result);
    }

    /**
     * 别人的迭代版本
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
