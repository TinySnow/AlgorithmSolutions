package leetcode.official;

import junit.framework.TestCase;

public class Question69Test extends TestCase {

    public void testOne() {
        assertEquals(2, Question69.mySqrt(4));
    }

    public void testTwo() {
        assertEquals(2, Question69.mySqrt(8));
    }

    public void testThree() {
        assertEquals(100, Question69.mySqrt(10000));
    }

    public void testFour() {
        assertEquals(10, Question69.mySqrt(120));
    }

    public void testFive() {
        assertEquals(46339, Question69.mySqrt(2147395599));
    }
}