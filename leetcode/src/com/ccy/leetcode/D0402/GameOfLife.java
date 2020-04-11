package com.ccy.leetcode.D0402;


/**
 * leetcode: 289
 * 难度：中等
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int outLen = board.length;
        if(outLen == 0){
            return;
        }
        int toDead = -2;
        int toLive = -1;
        int[] oArr = {1,1,1,-1,-1,-1,0,0};
        int[] iArr = {0,1,-1,0,1,-1,1,-1};
        int inLen = board[0].length;
        for(int i = 0; i < outLen; i++){
            for(int j = 0; j < inLen; j++){
                int liveNum = 0;
                for(int k = 0; k < 8; k++){
                    int t1 = i + oArr[k];
                    if(t1 < 0 || t1 >= outLen){
                        continue;
                    }
                    int t2 = j + iArr[k];
                    if(t2 < 0 || t2 >= inLen){
                        continue;
                    }
                    if(board[t1][t2] == 1 || board[t1][t2] == toDead){
                        liveNum ++;
                    }
                }
                if(liveNum < 2 && board[i][j] == 1){
                    board[i][j] = toDead;
                    continue;
                }
                if(liveNum == 3 && board[i][j] == 0){
                    board[i][j] = toLive;
                    continue;
                }
                if(liveNum > 3 && board[i][j] == 1){
                    board[i][j] = toDead;
                    continue;
                }
            }

        }
        for(int i = 0; i < outLen; i++){
            for(int j = 0; j < inLen; j++){
                if(board[i][j] == toDead){
                    board[i][j] = 0;
                }else if(board[i][j] == toLive){
                    board[i][j] = 1;
                }
            }
        }

    }
}
