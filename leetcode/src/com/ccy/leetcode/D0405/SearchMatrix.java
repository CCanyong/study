package com.ccy.leetcode.D0405;

/**
 * 探索二维矩阵
 * leetcode: 74
 * 难度: 中等
 */
public class SearchMatrix {

    int oLen;
    int iLen;
    int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        oLen = matrix.length;
        if (oLen == 0) {
            return false;
        }
        iLen = matrix[0].length;
        if (iLen == 0) {
            return false;
        }
        int length = oLen * iLen;
        return back(target, 0, length-1);
    }


    public boolean back(int target, int low, int up) {
        if (low > up) {
            return false;
        }
        if (low == up) {
            int o = low / iLen;
            int i = low % iLen;
            if (matrix[o][i] == target) {
                return true;
            }
            return false;
        }
        int now = (low + up) / 2;
        int o = now / iLen;
        int i = now % iLen;
        if (matrix[o][i] == target) {
            return true;
        }
        if (matrix[o][i] < target) {
            return back(target, now + 1, up);
        } else {
            return back(target, low, now - 1);
        }
    }
}
