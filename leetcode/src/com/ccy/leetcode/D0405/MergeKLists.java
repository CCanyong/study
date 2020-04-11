package com.ccy.leetcode.D0405;

import com.ccy.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 合并k个链表
 * leetcode: 23
 * 难度: 困难
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o, Object t) {
                ListNode o1 = (ListNode) o;
                ListNode t1 = (ListNode) t;
                if (o1.val < t1.val) {
                    return -1;
                }
                if (o1.val == t1.val) {
                    return 0;
                }
                return 1;
            }
        });

        for(ListNode node:lists){
            if(node!=null)
                priorityQueue.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (priorityQueue.peek() != null){
            ListNode poll = priorityQueue.poll();
            tmp.next = poll;
            tmp = tmp.next;
            poll = poll.next;
            if(poll!=null)
                priorityQueue.add(poll);
        }
        return head.next;
    }
}