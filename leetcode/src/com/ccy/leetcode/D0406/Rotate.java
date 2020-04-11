package com.ccy.leetcode.D0406;

/**
 * 旋转矩阵
 * leetcode: 面试题01.07
 * 难度: 中等
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int length = matrix.length - 1;
        int times = length / 2;
        for (int i = 0; i <= times; i++) {
            for (int j = i; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = matrix[j][length - i];
                matrix[j][length - i] = tmp;
            }
        }
    }
}
