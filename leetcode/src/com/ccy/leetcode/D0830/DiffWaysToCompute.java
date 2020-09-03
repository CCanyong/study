package com.ccy.leetcode.D0830;

import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 *
 * @author 陈灿勇
 * @version 0.0.1
 * @since 31/08/2020 00:37
 */
public class DiffWaysToCompute {

    private HashMap<Integer, Integer> cache = null;
    private List<Integer> nums = null;
    private List<Character> computeChar = null;

    public List<Integer> diffWaysToCompute(String input) {
        cache = new HashMap<>();
        int tmp = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                computeChar.add(input.charAt(i));
                nums.add(tmp);
                tmp = 0;
            } else {
                tmp = tmp * 10 + (c - '0');
            }
        }
        return null;
    }
}
