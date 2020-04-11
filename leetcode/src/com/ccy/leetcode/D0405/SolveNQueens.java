package com.ccy.leetcode.D0405;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后
 * leetcode: 51
 * 难度: 困难
 */
public class SolveNQueens {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return res;
        }
        back(0, n, new int[n]);
        return res;
    }

    public void back(int i, int n, int[] tmp) {
        if (i == n) {
            List<String> s = new ArrayList<>();
            for (int l = 0; l < n; l++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int o = 0; o < tmp[l]; o++) {
                    stringBuffer.append('.');
                }
                stringBuffer.append('Q');
                for (int o = tmp[l] + 1; o < n; o++) {
                    stringBuffer.append('.');
                }
                s.add(stringBuffer.toString());
            }
            res.add(s);
            return;
        }
        for (int k = 0; k < n; k++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (k == tmp[j]) {
                    flag = false;
                    break;
                }
                int t1 = k - tmp[j];
                if ((i - j == t1) || (i-j == t1*-1)) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                tmp[i] = k;
                back(i + 1, n, tmp);
            }
        }
    }
}
