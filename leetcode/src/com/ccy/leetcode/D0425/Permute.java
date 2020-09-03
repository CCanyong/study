package com.ccy.leetcode.D0425;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 难度：中等
 * leetcode: 46
 *
 * @author 陈灿勇
 * @version 0.0.1
 * @since 25/04/2020 09:36
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        back(nums, new ArrayList<>(), 0);
        return res;
    }

    void back(int[] nums, List<Integer> tmp, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            tmp.add(nums[index]);
            back(nums, tmp, index + 1);
            tmp.remove(index);
            swap(nums, index, i);
        }
    }

    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
