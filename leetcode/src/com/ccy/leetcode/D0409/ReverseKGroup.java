package com.ccy.leetcode.D0409;

import com.ccy.leetcode.common.ListNode;

/**
 * k个一组反转链表
 * leetcode: 25
 * 难度: 困难
 */
public class ReverseKGroup {
    ListNode tmp;
    ListNode t1;
    ListNode next;
    ListNode next1;
    public ListNode reverseKGroup(ListNode head, int k) {
        tmp = head;
        int i = 0;
        while (i < k) {
            if (tmp == null)
                return head;
            tmp = tmp.next;
            i++;
        }
        t1 = head;
        i = 0;
        while (i < k-1) {
            next = t1.next;
            next1 = next.next;
            next.next = head;
            t1.next = next1;
            head = next;
            i++;
        }
        t1.next = reverseKGroup(tmp, k);
        return head;
    }
}
