package leetcode.official;

import junit.framework.TestCase;
import necessary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question94Test extends TestCase {

    public void testNull() {
        assertEquals(new ArrayList<Integer>(), Question94.inorderTraversal(new TreeNode()));
    }
}