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
public class Question590 {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        method(root, result);
        return result;
    }

    private void method(Node node, ArrayList<Integer> result) {
        if (node.children != null) {
            for (Node child : node.children) {
                method(child,result);
            }
        }
        result.add(node.val);
    }
}
