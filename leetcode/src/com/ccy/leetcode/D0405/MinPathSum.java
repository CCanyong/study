package com.ccy.leetcode.D0405;

/**
 * 最小路径和
 * leetcode: 64
 * 难度: 中等
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int oLen = 0;
        int iLen = 0;
        if ((oLen = grid.length) == 0 || (iLen = grid[0].length) == 0) {
            return 0;
        }
        for (int i = 1; i < oLen; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < iLen; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < oLen; i++) {
            for (int j = 1; j < iLen; j++) {
                grid[i][j] += (grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j]);
            }
        }
        return grid[oLen - 1][iLen - 1];
    }
}
