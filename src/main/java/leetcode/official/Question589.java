package leetcode.official;

import necessary.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public class Question589 {
    public List<Integer> preorder(Node root) {
        // 根节点空判断
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    /**
     * 递归程序
     *
     * @param node   传入节点
     * @param result 将字符串传递
     */
    private void recursion(Node node, ArrayList<Integer> result) {
        result.add(node.val);
        for (Node child : node.children) {
            recursion(child, result);
        }
    }

    List<Integer> list = new ArrayList<>();

    /**
     * 另一个递归版本，和上面 list 搭配使用
     *
     * @param root
     * @return
     */
    public List<Integer> preorderAnotherRecursionVersion(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children) preorderAnotherRecursionVersion(node);
        return list;
    }

    /**
     * 迭代版本
     *
     * @param root
     * @return
     */
    public List<Integer> preorderIterative(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }

}
