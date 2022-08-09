package leetcode.official;

import junit.framework.TestCase;

public class Question26Test extends TestCase {

    public void testNull() {
    }

    public void testOne() {
        assertEquals(1,Question26.removeDuplicates(new int[]{1}));
    }

    public void testTwoDup() {
        assertEquals(1,Question26.removeDuplicates(new int[]{2,2}));

    }

    public void testTwoNoDup() {
        assertEquals(2,Question26.removeDuplicates(new int[]{1,2}));
    }

    public void testThreeElementsNoDup() {
        assertEquals(3,Question26.removeDuplicates(new int[]{1,2,3}));
    }

    public void testThreeElementsOneDup() {
        assertEquals(2,Question26.removeDuplicates(new int[]{1,2,2}));
        assertEquals(2,Question26.removeDuplicates(new int[]{1,1,2}));
    }

    public void testThreeElementsTwoDup() {
        assertEquals(1,Question26.removeDuplicates(new int[]{1,1,1}));
    }
}