package com.ccy.leetcode.D0830;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 30/08/2020 16:54
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = rw.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        int first = -1;
        int last = first;
        if (s.length() == 0 || s.trim().length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        while (last + 1 < s.length()) {
            while(last + 1 < s.length() && s.charAt(last + 1) != ' '){
                last ++;
            }
            if (last + 1 <= s.length() && first == last) {    // 单词只有一个字母，则跳过当前单词
                last += 1;
            }
            int tmp = last;
            while (last > first) {
                sb.append(s.charAt(last));
                last --;
            }
            last = tmp;
            first = last;
        }
        return sb.toString();
    }

}
