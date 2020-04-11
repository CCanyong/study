package com.ccy.leetcode.D0409;

/**
 * Z字形变换
 * leetcode: 6
 * 难度: 中等
 */
public class Convert {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int k = 0;
        int tmp = numRows * 2 - 2;
        while (k < chars.length) {
            stringBuffer.append(chars[k]);
            k += tmp;
        }
        for (int i = 1; i < numRows - 1; i++) {
            k = i;
            while (k < chars.length) {
                stringBuffer.append(chars[k]).append(chars[k + numRows - i + 1]);
                k += tmp;
            }
        }
        k = numRows - 1;
        while (k < chars.length) {
            stringBuffer.append(chars[k]);
            k += tmp;
        }
        return stringBuffer.toString();
    }
}
