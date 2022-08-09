package leetcode.official;

import necessary.ListNode;

public class Question25 {
    /**
     * 好难……
     * 不想写注释了
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 边界判断
        // 注意此处 k = 1 的情况，此时不用翻转，或者说每一个都要翻转，但是翻转过后效果一样
        // 所以直接返回 head 即可
        if (k < 2 || k > 5000 || head == null) {
            return head;
        }
        // 启动计数，计算是否应该翻转
        int count = 1;
        ListNode prev, next, curHead = head, curTail, newHead = null, lastHead = null;
        while (head != null) {
            next = head.next;
            // 如果当前计数等于需要翻转的基本条件
            // 进行链表反转，然后移动指针，保存当前 next 的位置到 save，以备下次使用，同时将 count 置一
            // 则直接移动指针，然后 count++
            if (count % k == 0) {
                // 保存当前位置为当前需要翻转链表的尾部
                curTail = head;
                // 将之前保存的当前链表的头部赋值给 head
                head = curHead;
                // 这样做是为了能直接链接下一个结点，而不需要进行额外操作
                prev = next;
                // 反转链表
                while (prev != curTail) {
                    next = head.next;
                    head.next = prev;
                    prev = head;
                    head = next;
                }
                // 如果是第一次翻转，则需要拿到整个链表的 head，也就是第一次的 tail
                // 否则的话，就将上一次翻转的部分链表的 head 连接到当前翻转的部分链表的 tail（翻转后的 tail 实际上是头）
                if (count == k) newHead = curTail;
                else lastHead.next = curTail;
                // 移动 lastHead 指针
                lastHead = curHead;
                // 保存当前 head 位置
                curHead = head;
                // 此步是链接一个部分翻转的链表，和一个不能翻转的（未达到 k）的部分链表的头
                // 如果后者能反转，自然会被上面那个 if 替代
                lastHead.next = curHead;
                count++;
            }
            // 此处 next 可能空指针，发生在 k == head 链表的 length 时
            if (head != null) next = head.next;
            prev = head;
            head = next;
            count++;
        }
        return newHead;
    }
}
