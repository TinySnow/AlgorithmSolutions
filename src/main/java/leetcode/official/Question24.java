package leetcode.official;

import necessary.ListNode;

public class Question24 {
    /**
     * 此题逻辑有点复杂，建议好好看
     * 自己写的题解，没有借鉴别人的做法
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        // 边界判断，判断是否满足基本条件
        if (head == null || head.next == null) {
            return head;
        }
        // 计数当前 head 指针是否需要交换
        int count = 1;
        // 前一指针，后一指针，新头节点（新头节点总是第二个结点的地址，因为 null 和单节点已经在边界判断里派出了），保存指针
        ListNode prev = null, next, newHead = head.next, save = null;
        while (head != null) {
            // 每次开头刷新 next 指针，以免放到最后出现空指针异常
            next = head.next;
            // 当需要交换的时候执行 prev 指向下一节点，然后 head 指向 prev 完成交换
            // 注意，因为前后位置交换了，所以此时的情况应该是：
            //      O     ->     O       ->      O
            //     head         prev            next
            // 然后 save 指针指向 head 完成链表链接，注意此处的 count != 2 条件
            // 因为 save 总是设定为 prev 的上一节点
            // 而 head 处于第二结点的时候，prev 还是第一节点，所以 save 指针此时是第零结点，也就是 null，会报空指针
            // 所以需要加一个这个条件
            // 之后 head 指针会移动到 next 指针处，prev 指针不用动，刚好变成移动完毕的样子
            //      O     ->     O       ->      O
            //                  prev            head
            if (count % 2 == 0) {
                prev.next = next;
                head.next = prev;
                if (count != 2){
                    save.next = head;
                }
            }
            // 如果不需要交换，则简单移动两个指针（next 指针会在每次循环开头刷新，所以此处不需担心 next 指针）
            // 注意此处需要保存 prev 指针到 save 里面，因为 prev 指针即将移动到 head 指针去
            else{
                save = prev;
                prev = head;
            }
            // 移动 head 指针到下一节点
            head = next;
            count++;
        }
        return newHead;
    }
}
