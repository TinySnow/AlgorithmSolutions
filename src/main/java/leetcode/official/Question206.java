package leetcode.official;

import necessary.ListNode;

public class Question206 {
    /**
     * 翻转链表，三个指针，一前一后和头指针
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 边界判断，判断基本条件是否满足
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, next;
        // 注意循环里第一句不能放到最后去，否则可能空指针异常
        while (head != null) {
            // 保存当前头结点的下一个结点
            next = head.next;
            // 将当前头节点的 next 指向上一个节点，即头插法
            head.next = prev;
            // 将上一节点的指针移动到当前头结点的位置
            prev = head;
            // 将当前头结点移动到当前头结点的下一节点
            head = next;
            // 注意，循环体第一句不能放到这个位置，因为这个时候 next，也就是 head 可能是链表的尾结点了
            // 尾结点是 null，所以会空指针
        }
        // 因为最后跳出的时候 head 一定是 null，而这个时候上一个节点实际上就是头节点，所以返回上一结点
        return prev;
    }
}
