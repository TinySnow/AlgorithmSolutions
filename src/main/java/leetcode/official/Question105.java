package leetcode.official;

import necessary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Question105 {
    /**
     * 1. 递归，逻辑要看懂。
     * 自己写的第一版不知道哪儿错了……
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 将中序遍历以<元素值，元素索引>的形式存入 map，加快查询
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        // 构造树
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        // 当 pre 和 in 的边界值不构成数组时退出
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int remains = inRoot - inStart;
        // 难点，这里要算清边界
        // 先序：--根--   --------------左子树---------------   -----------------右子树-----------------
        //              ps                       ps+length   ps+length+1                                 pe
        // 中序：--------------左子树---------------   --根--   -----------------右子树-----------------
        //     is (ir-is==left_subtree_length) ir-1   ir    ir+1                                  ie
        root.left = buildTree(preorder, preStart + 1, preStart + remains, inStart, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + remains + 1, preEnd, inRoot + 1, inEnd, map);
        return root;
    }
}
