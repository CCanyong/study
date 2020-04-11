package com.ccy.leetcode.D0406;

public class NumIslands {

    public int numIslands(char[][] grid) {
        if ( grid.length == 0 || grid[0].length == 0)
            return 0;
        int oLen = grid.length;
        int iLen = grid[0].length;
        int res = 0;
        for (int i = 0; i < oLen; i++) {
            for (int j = 0; j < iLen; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int oLen = grid.length;
        int iLen = grid[0].length;
        if (i < 0 || j < 0 || i >= oLen || j >= iLen || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}
