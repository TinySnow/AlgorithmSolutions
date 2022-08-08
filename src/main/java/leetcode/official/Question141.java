package leetcode.official;

import necessary.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Question141 {
    /**
     * 最终选择：方法 2
     *
     * 1. hash 法，记录访问过的元素，看后面是否再次访问
     * 2. 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 方法 1
     *
     * @param head
     * @return
     */
    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
