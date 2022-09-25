package leetcode.official;

import junit.framework.TestCase;

public class Question122Test extends TestCase {

    public void testOne() {
        assertEquals(7, Question122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public void testTwo() {
        assertEquals(4, Question122.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public void testThree() {
        assertEquals(0, Question122.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}