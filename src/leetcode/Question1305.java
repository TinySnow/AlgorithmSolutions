package leetcode;

import necessary.TreeNode;

import java.util.*;

public class Question1305 {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // 为空判定
        if (root1 == null && root2 == null) {
            return new ArrayList<>();
        }
        // Key 为数字，Value 为出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 结果
        List<Integer> result = new ArrayList<>();
        // 将 root1 遍历，所有结果加进 map 里，下同
        if (root1 != null) {
            BFS(root1, map);
        }
        if (root2 != null) {
            BFS(root2, map);
        }
        // 根据 map 的 Key 建立 list
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // 然后排序
        list.sort(Map.Entry.comparingByKey());
        // 根据此升序，进行 list 的遍历
        for (Map.Entry<Integer, Integer> entry : list) {
            // 取出每个元素，然后根据 map 的 Value（出现次数）重复添加
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static void BFS(TreeNode root, HashMap<Integer, Integer> map) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        // 中序遍历
        while (!stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (map.containsKey(node.val)) {
                    map.replace(node.val, map.get(node.val) + 1);
                } else {
                    map.put(node.val, 1);
                }
                node = node.right;
            }
        }
        map.replace(root.val,  map.get(root.val) - 1);
    }
/**
 * 以下是宫水的解法
 */
//    int INF = 0x3f3f3f3f;
//    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//        List<Integer> ans = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
//        dfs(root1, l1); dfs(root2, l2);
//        int n = l1.size(), m = l2.size(), i = 0, j = 0;
//        while (i < n || j < m) {
//            int a = i < n ? l1.get(i) : INF, b = j < m ? l2.get(j) : INF;
//            if (a <= b) {
//                ans.add(a); i++;
//            } else {
//                ans.add(b); j++;
//            }
//        }
//        return ans;
//    }
//    void dfs(TreeNode root, List<Integer> list) {
//        if (root == null) return ;
//        dfs(root.left, list);
//        list.add(root.val);
//        dfs(root.right, list);
//    }
}
