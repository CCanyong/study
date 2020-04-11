package com.ccy.leetcode.D0403;

/**
 * 字符串转换整数
 */
public class MyAtoi {

    public int myAtoi(String str) {
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        boolean flag = true;
        if(i >= str.length()){
            return 0;
        }
        char c = str.charAt(i);
        if (c == '+') {
            i++;
        } else if (c == '-') {
            i++;
            flag = false;
        } else if (c > '9' || c < '0') {
            return 0;
        }
        long res = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                break;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                if (flag)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
        }
        if(!flag){
            res = -1 * res;
        }
        return (int)res;
    }
}
