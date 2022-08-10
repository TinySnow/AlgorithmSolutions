package leetcode.official;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Question1Test extends TestCase {

    public void testTwo() {
        assertArrayEquals(new int[]{0, 1}, Question1.twoSum(new int[]{3, 3}, 6));
    }

    public void testFour() {
        assertArrayEquals(new int[]{0, 1}, Question1.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public void testThree() {
        assertArrayEquals(new int[]{1, 2}, Question1.twoSum(new int[]{3, 2, 4}, 6));
    }
}