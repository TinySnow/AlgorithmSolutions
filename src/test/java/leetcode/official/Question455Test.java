package leetcode.official;

import junit.framework.TestCase;

public class Question455Test extends TestCase {

    public void testOne() {
        assertEquals(1, Question455.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    public void testTwo() {
        assertEquals(2, Question455.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public void testThree() {
        assertEquals(2, Question455.findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}