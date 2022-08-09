package leetcode.official;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Question189Test extends TestCase {

    public int[] case1 = new int[]{1,2,3,4,5,6,7};
    public int[] case2 = new int[]{-1,-100,3,99};

    public void testNull() {
        assertNull(Question189.rotateTest(null,2));
    }

    public void testCase1() {
        assertArrayEquals(new int[]{5,6,7,1,2,3,4},Question189.rotateTest(case1,3));
    }

    public void testCase2() {
        assertArrayEquals(new int[]{3,99,-1,-100},Question189.rotateTest(case2,2));
    }
}