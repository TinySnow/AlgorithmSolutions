package leetcode.official;

import necessary.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null && l1.val == 0 && l2.val == 0) {
            return new ListNode(0);
        }
        int carryFlag = 0;
        ListNode result = null;
        ListNode rear = null;
        // 两个指针同时开始走
        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + carryFlag;
            carryFlag = number >= 10 ? 1 : 0;
            ListNode current = new ListNode(number >= 10 ? number % 10 : number, null);
            // 如果是第一轮循环，即产生的是头结点，就把这个地址设为链尾和链头，返回该地址，结束当前循环
            // 否则则将其链接到链尾
            if (result == null) {
                rear = current;
                result = rear;
            } else {
                rear.next = current;
                rear = rear.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode longerListPointer = l1 != null ? l1 : l2;
        // 当 l1 和 l2 有一个已经循环完时出现下面的情况
        if (l1 == null && l2 == null) {
            // 当两个等长并且有进位，则需要多新添加一个结点
            // 如果没有则说明没有进位，无需添加新结点
            if (carryFlag == 1) {
                rear.next = new ListNode(1, null);
            }
        } else {
            // 当两个不等长时，可以直接调用长的后半的数据
            // 不过还是需要看是否有进位，否则可能最坏情况上溢到末尾结点
            // 如果一直有进位，则一直执行这个循环
            while (carryFlag == 1) {
                // 加上进位计算当前值，看是否仍然溢出
                int judge = longerListPointer.val + carryFlag;
                carryFlag = judge >= 10 ? 1 : 0;
                // 上溢过程中创建新结点，值为相加后末尾的数字，并将其链接到队尾
                rear.next = new ListNode(judge % 10, null);
                // 移动队尾指针
                rear = rear.next;
                // 移动长链指针
                longerListPointer = longerListPointer.next;
                if (longerListPointer == null){
                    break;
                }
            }
            // 如果没有进位了，会有两种情况，一种是长链已经走到末尾了，另一种是长链还没有走到末尾
            // 一直上溢到最后会执行这个 if
            // 上溢到最后并且有进位，则新创建一个结点，链接到队尾，结束循环
            if (longerListPointer == null) {
                if (carryFlag != 0){
                    rear.next = new ListNode(1, null);
                }
            } else {
                rear.next = longerListPointer;
            }
        }
        return result;
    }
}
