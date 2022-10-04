package leetcode.official;

import junit.framework.TestCase;

public class Question33Test extends TestCase {

    public void testOne() {
        assertEquals(4,Question33.search(new int[]{4,5,6,7,0,1,2},0));
    }

    public void testTwo() {
        assertEquals(-1,Question33.search(new int[]{4,5,6,7,0,1,2},3));
    }

    public void testThree() {
        assertEquals(-1,Question33.search(new int[]{1},0));
    }

    public void testFour() {
        assertEquals(1,Question33.search(new int[]{1,3},1));
    }

    public void testFive() {
        assertEquals(-1,Question33.search(new int[]{1,3,5},0));
    }
}