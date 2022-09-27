package leetcode.official;

import junit.framework.TestCase;

public class Question45Test extends TestCase {

    public void testOne() {
        assertEquals(2, Question45.jump(new int[]{2, 3, 1, 1, 4}));
    }

    public void testTwo() {
        assertEquals(1, Question45.jump(new int[]{1, 2, 3}));
    }
}