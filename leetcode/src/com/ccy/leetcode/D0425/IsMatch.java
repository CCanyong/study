package com.ccy.leetcode.D0425;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 25/04/2020 10:14
 */
public class IsMatch {


    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        if (j == pattern.length()) {
            return i == text.length();
        }
        boolean match = (i < text.length()
                && (text.charAt(i) == pattern.charAt(j)
                || pattern.charAt(j) == '.'));
        boolean ans;
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            ans = (dp(i, j + 2, text, pattern) ||
                    match && dp(i + 1, j, text, pattern));
        } else {
            ans = match && dp(i + 1, j + 1, text, pattern);
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}

enum Result {
    TRUE, FALSE
}