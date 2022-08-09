package leetcode.official;

import necessary.ListNode;

public class Question21 {
    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                handler.next = list1;
                list1 = list1.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
            }
            handler = handler.next;
        }
        if (list1 != null) {
            handler.next = list1;
        } else {
            handler.next = list2;
        }
        return head.next;
    }
}
