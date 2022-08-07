package leetcode.official;

import necessary.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Question653 {
    public boolean findTarget(TreeNode root, int k) {
        // 此题暂无边界判断
        if (root == null) {
            return false;
        }
        // 存放用 K - Node.val 值的 set
        Set<Integer> set = new HashSet<>();
        Set<Boolean> result = new HashSet<>();
        // 开始搜索
        search(root, k, set, result);
        // 最后直接看 result 集合里有没有 TRUE 就行
        return result.contains(Boolean.TRUE);
    }

    private void search(TreeNode root, int k, Set<Integer> set, Set<Boolean> result) {
        // 如果当前节点为空，或者 result set 里面已经包含了 true，则说明可以不用进行递归了，直接返回
        if (root == null || result.contains(Boolean.TRUE)) {
            return;
        }
        // 如果 set 已经包含了当前节点的值
        // 说明，在之前某一次递归中，有一个结点 N，其被 K 减去的值 V 已经被添加进了 set
        // 这个值 V 恰好与当前结点 Node.val 的值相等
        // 由此我们可以推断
        // N.val + Node.val == k
        // 所以应当往 result set 里面添加 true，然后结束递归
        if (set.contains(root.val)) {
            result.add(Boolean.TRUE);
            return;
        } else {
            // 否则则应当继续添加值进入 set
            // 该值 == K - Node.val
            set.add(k - root.val);
        }
        // 进行左子树递归
        search(root.left, k, set, result);
        // 进行右子树递归
        search(root.right, k, set, result);
    }
}
