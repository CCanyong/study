package com.ccy.leetcode.D0406;

/**
 * 编辑距离
 * leetcode: 72
 * 难度: 困难
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return m + n;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]))+1;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = min < dp[i-1][j-1] ? min : dp[i-1][j-1];
                } else {
                    dp[i][j] = min;
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        new MinDistance().minDistance("horse","ros");
    }
}
