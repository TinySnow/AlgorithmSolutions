package leetcode.official;

import junit.framework.TestCase;
import necessary.ListNode;

public class Question24Test extends TestCase {

    public void testNull() {
        assertNull(Question24.swapPairs(null));
    }

    public void testOne() {
        assertEquals(new ListNode(1, null), Question24.swapPairs(new ListNode(1)));
    }

    public void testTwo() {
        assertEquals(new ListNode(5, new ListNode(6, null)),
                Question24.swapPairs(new ListNode(6, new ListNode(5))));

    }

    public void testFour() {
        assertEquals(new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3, null)))),
                Question24.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))));

    }
}