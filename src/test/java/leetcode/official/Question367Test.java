package leetcode.official;

import junit.framework.TestCase;

public class Question367Test extends TestCase {

    public void testOne() {
        assertTrue(Question367.isPerfectSquare(16));
    }

    public void testTwo() {
        assertFalse(Question367.isPerfectSquare(14));
    }

    public void testThree() {
        assertTrue(Question367.isPerfectSquare(104976));
    }
}