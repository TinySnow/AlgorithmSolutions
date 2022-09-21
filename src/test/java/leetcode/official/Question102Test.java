package leetcode.official;

import junit.framework.TestCase;
import necessary.TreeNode;

public class Question102Test extends TestCase {

    public void testSingleRoot() {
        System.out.println(Question102.levelOrder(new TreeNode(1, null, null)));
    }

    public void testNull() {
        System.out.println(Question102.levelOrder(null));
    }

    public void testOne() {
        System.out.println(Question102.levelOrder(new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null))))
        );
    }
}