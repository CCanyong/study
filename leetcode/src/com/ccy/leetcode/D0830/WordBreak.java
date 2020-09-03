package com.ccy.leetcode.D0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 140. 单词拆分 II
 *
 * @author 陈灿勇
 * @version 0.0.1
 * @since 30/08/2020 23:31
 */
public class WordBreak {

    private static List<String> res = null;
    private static List<String> wordDict = null;

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        List<String> words = Arrays.asList(dict);
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak(s, words);
        System.out.println(res);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        this.wordDict = wordDict;
        back(s, new ArrayList<>(), 0);
        return res;
    }

    private void back(String s, List<String> words, int start) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String tmp = wordDict.get(i);
            if (s.startsWith(tmp, start)) {
                words.add(tmp);
                back(s, words, start + tmp.length());
                words.remove(words.size() - 1);
            }
        }
    }
}
