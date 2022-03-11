package leetcode;

import necessary.Node;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Integer> result = new ArrayList<>();
        // 根节点空判断
        if (root != null) {
            method(root, result);
        }
        return result;
    }

    /**
     * 递归程序
     * @param node 传入节点
     * @param result 将字符串传递
     */
    private void method(Node node, ArrayList<Integer> result) {
        result.add(node.val);
        for (Node child : node.children) {
            method(child, result);
        }
    }
}
