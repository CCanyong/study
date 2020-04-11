package com.ccy.leetcode.D0409;

/**
 * 翻转字符串里的单词
 * leetcode:151
 * 难度:中等
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        for (int i = words.length - 1; i >= 0; i--) {
            if (words.equals("")) {
                continue;
            }
            stringBuffer.append(words[i] + " ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }
}
