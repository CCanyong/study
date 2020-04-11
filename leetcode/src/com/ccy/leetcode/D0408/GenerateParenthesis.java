package com.ccy.leetcode.D0408;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParenthesis {

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(5);
    }

    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        ArrayList<String> zero = new ArrayList<>();
        zero.add("");
        map.put(0, zero);
        for (int i = 1; i <= n; i++) {
            ArrayList<String> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String s1 : map.get(j)) {
                    for (String s2 : map.get(i - 1 - j)) {
                        tmp.add("(" + s1 + ")" + s2);
                    }
                }
            }
            map.put(i,tmp);
        }
        return map.get(n);

    }

}
