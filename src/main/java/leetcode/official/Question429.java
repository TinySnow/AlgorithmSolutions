package leetcode.official;

import necessary.Node;

import java.util.*;

public class Question429 {
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
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
        while (size-- > 0) {
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

    /**
     * 别人的迭代版本
     * 其实好像可以不用递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderIterative(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            // 注意，此处 queue 的 size 不能内联进 for，因为 queue 是动态增长的
            // 内联进去会导致每次循环结束之后，size 不一样
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        return ret;
    }
}
