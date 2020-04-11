package com.ccy.leetcode.D0406;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * leetcode: 239
 * 难度: 困难
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0)
            return new int[0];
        if (k == 1)
            return nums;
        Deque<Integer> integers = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            integers.addFirst(i);
            while (true) {
                int tmp = integers.removeLast();
                
                if (tmp >= nums[i]) {
                    integers.addLast(tmp);
                    break;
                }
            }
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[integers.getLast()];
        for (int i = k; i < nums.length; i++) {
            if (1 - integers.getLast() == k) {
                integers.removeLast();
            }
            integers.addFirst(i);
            while (true) {
                int tmp = integers.removeLast();
                if (tmp >= nums[i]) {
                    integers.addLast(tmp);
                    break;
                }
            }
            res[i - k + 1] = nums[integers.getLast()];
        }
        return res;
    }
}
