package leetcode.official;

import necessary.ListNode;

public class Question142 {
    /**
     * 1. Hash 记录，但是这个很麻烦
     * 2. 快慢指针，简单，但是需要一点点数学计算
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 如果有环，两个相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        // 因为循环中止有可能是跳出或者结束
        // 如果是结束，说明没有环，直接返回，判断条件就是有没有下一节点
        // 如果是跳出，则有环，不满足没有下一节点这个条件
        if (fast == null || fast.next == null) return null;
        // 因为快指针两倍于慢指针
        // 设，头结点到环开始的地方为 A，在环内走了 B，环长为 C
        // 则      二倍慢指针 = 快指针（A + 超一整圈的 C + 慢指针超过环开始的结点距离 B）
        // 即        2(A+B) = A+C+B      =>      A+B = C
        // 而 B 在环内，所以将 C 拆开成 B+D（D 为追上的地点到环开始的，与 B 互补的距离）
        // 约去得 A = D
        // 所以此时我们可以启动头指针，也启动慢指针，因为距离相同，所以相遇的时候，一定在环开始的地方
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
