package com.ccy.leetcode.D0409;

import java.util.HashSet;
import java.util.Set;

/**
 * 解数独
 * leetcode: 37
 * 难度: 困难
 */
public class SolveSudoku {

    char[][] rowSet = new char[9][9];
    char[][] colSet = new char[9][9];
    char[][] spaceSet = new char[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowSet[i][j] = '0';
                colSet[i][j] = '0';
                spaceSet[i][j] = '0';
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '0';
                    rowSet[i][t - 1] = '1';
                    colSet[j][t - 1] = '1';
                    spaceSet[i / 3 * 3 + j / 3][t - 1] = '1';
                }
            }
        }
        back(board, 0, 0);
    }

    public boolean back(char[][] board, int i, int j) {
        if (i == 8 && j == 8 && board[i][j] != '.') {
            return true;
        }
        if (board[i][j] != '.') {
            if (j == 8) {
                return back(board, i + 1, 0);
            }
            if (j < 8) {
                return back(board, i, j + 1);
            }
        }
        for (int k = 0; k < 9; k++) {
            if (rowSet[i][k] == '1' || colSet[j][k] == '1' || spaceSet[i / 3 * 3 + j / 3][k] == '1') {
                continue;
            }
            board[i][j] = (char) ('1' + k);
            rowSet[i][k] = '1';
            colSet[j][k] = '1';
            spaceSet[i / 3 * 3 + j / 3][k] = '1';
            boolean flag = false;
            if (i == 8 && j == 8) {
                return true;
            }
            if (j == 8) {
                flag = back(board, i + 1, 0);
            }
            if (j < 8) {
                flag = back(board, i, j + 1);
            }
            if (flag) {
                return true;
            }
            rowSet[i][k] = '0';
            colSet[j][k] = '0';
            spaceSet[i / 3 * 3 + j / 3][k] = '0';

        }
        board[i][j] = '.';
        return false;
    }

}
