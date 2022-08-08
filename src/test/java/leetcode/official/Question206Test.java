package leetcode.official;

import junit.framework.TestCase;
import necessary.ListNode;

public class Question206Test extends TestCase {
    public void testNull() {
        assertNull(Question206.reverseList(null));
        assertNull(Question206.reverseList(new ListNode(2, null)));
    }

    public void testTwoElement() {
        assertEquals(new ListNode(2,new ListNode(3,null)),
                Question206.reverseList(new ListNode(3,new ListNode(2,null))));
    }

    public void testThreeElement() {
        assertTrue(new ListNode(-1,new ListNode(3,new ListNode(5,null))).equals(
                Question206.reverseList(new ListNode(5,new ListNode(3,new ListNode(-1,null))))));
    }
}