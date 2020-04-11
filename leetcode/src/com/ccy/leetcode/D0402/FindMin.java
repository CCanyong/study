package com.ccy.leetcode.D0402;

/**
 * 寻找旋转排序数组中的最小值
 * leetcode: 153
 * 难度: 中等
 */
public class FindMin {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];

    }
}
