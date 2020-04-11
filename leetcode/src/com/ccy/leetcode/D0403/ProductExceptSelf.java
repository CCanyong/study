package com.ccy.leetcode.D0403;

/**
 * 除自身以外数组的乘积
 * leetcode: 238
 * 难度: 中等
 */
public class ProductExceptSelf {

    public int[] func2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // int left = 1;
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 2; i >= 0; i--) {
            right *= nums[i+1];
            res[i] *= res[i] * right;
        }
        return res;
    }


    /**
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     *
     * @param nums
     * @return
     */
    public int[] func1(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = nums[i] * left[i - 1];
            right[len - 1 - i] = nums[len - i - 1] * right[len - i];
        }
        int[] res = new int[len];
        res[0] = right[1];
        res[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}
