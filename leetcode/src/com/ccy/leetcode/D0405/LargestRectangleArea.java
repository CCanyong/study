package com.ccy.leetcode.D0405;

import java.util.Stack;

/**
 * 找柱状图中最大的矩形
 * leetcode: 84
 * 难度: 困难
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.peek()] * (i - 1 - heights[stack.pop()]));
            }
            stack.push(i);
        }

        while (stack.peek() != -1)
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxArea;
    }
}
