package leetcode.official;

import necessary.TreeNode;

import java.util.*;

public class Question102 {
    /**
     * 层次遍历，队列
     * 写的不好，推荐看别人的算法
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> parent = new LinkedList<>();
        parent.add(root);
        recursion(parent, new LinkedList<>(), result);
        return result;

//        List<List<Integer>> res = new ArrayList<>();
//
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if (root != null) {
//            queue.add(root);
//        }
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            List<Integer> level = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(level);
//        }
//
//        return res;
    }

    private static void recursion(Deque<TreeNode> parent, Deque<TreeNode> children, List<List<Integer>> result) {
        if (parent.isEmpty()) {
            return;
        }
        // null 则不加入队列
        for (TreeNode p : parent) {
            if (p != null) {
                children.add(p.left);
                children.add(p.right);
            }
        }
        ArrayList<Integer> level = new ArrayList<>();
        // null 也不加入 level list
        for (TreeNode node : parent) if (node != null) level.add(node.val);
        // 根据 level list 是否为空判断是否应该推入 result 队列
        if (!level.isEmpty()) result.add(level);
        recursion(children, new LinkedList<>(), result);
    }
}
