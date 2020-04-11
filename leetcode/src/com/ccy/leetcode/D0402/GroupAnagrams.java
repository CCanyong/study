package com.ccy.leetcode.D0402;

import java.util.*;

/**
 * 字母异位词分组
 * leetcode: 49
 * 难度： 中等
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(s,l);
            }
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;

    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<char[]> tmp = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            for (int j = 0; j < tmp.size(); j++) {
                if (chars.equals(chars)) {
                    res.get(j).add(strs[i]);
                    flag = false;
                    break;
                }
            }
            if(flag){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
                tmp.add(chars);
            }
        }
        return res;

    }
}
