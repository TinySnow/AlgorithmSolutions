package leetcode.official;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Question66Test extends TestCase {

    public void testThree() {
        assertArrayEquals(new int[]{1, 2, 4}, Question66.plusOne(new int[]{1, 2, 3}));
    }

    public void testOne9() {
        assertArrayEquals(new int[]{1, 0}, Question66.plusOne(new int[]{9}));
    }

    public void testFour() {
        assertArrayEquals(new int[]{4, 3, 2, 2}, Question66.plusOne(new int[]{4, 3, 2, 1}));
    }
}