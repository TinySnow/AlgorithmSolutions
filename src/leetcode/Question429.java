package leetcode;

import necessary.Node;

import java.util.*;

public class Question429 {
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        // 添加根节点
        // 每层的 List
        List<Integer> storey = new ArrayList<>();
        // 将根节点添加进去
        queue.addLast(root);
        // 开始递归
        recursion(queue, result);
        return result;
    }

    private static void recursion(Deque<Node> queue, List<List<Integer>> result) {
        ArrayList<Integer> storey = new ArrayList<>();
        int size = queue.size();
        // 先将此层出队，并且添加到 storey
        // 出队每个结点时，将其孩子添加到队列中
        while (size-- >0) {
            Node node = queue.poll();
            storey.add(node.val);
            if (node.children != null) {
                queue.addAll(node.children);
            }
        }
        // 将每层(storey)推入 result，然后清空
        result.add(storey);
        // 如果队列不为空，继续递归
        if (!queue.isEmpty()) {
            recursion(queue, result);
        }
    }
}
