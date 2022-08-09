package leetcode.official;

import junit.framework.TestCase;
import necessary.ListNode;

public class Question25Test extends TestCase {
    public ListNode case1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5,null)))));

    public void testOne() {
        assertEquals(case1,Question25.reverseKGroup(case1,1));
    }

    public void testTwo() {
        assertEquals(new ListNode(2,new ListNode(1,new ListNode(4,new ListNode(3, new ListNode(5,null))))),
                Question25.reverseKGroup(case1,2));

    }

    public void testOnlyTwo() {
        assertEquals(new ListNode(2,new ListNode(1,null)),
                Question25.reverseKGroup(new ListNode(1,new ListNode(2,null)),2));

    }

    public void testThree() {
        assertEquals(new ListNode(3,new ListNode(2,new ListNode(1,new ListNode(4, new ListNode(5,null))))),
                Question25.reverseKGroup(case1,3));

    }
}