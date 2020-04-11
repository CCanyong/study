package com.ccy.leetcode.D0405;

import java.util.LinkedList;

/**
 * 简化路径
 * leetcode: 71
 * 难度: 中等
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int start = 1;
        for (; start < dirs.length && (dirs[start].equals("") || dirs[start].equals("..") || dirs.equals(".")); start++)
            ;
        if (start == dirs.length)
            return "/";
        LinkedList<String> list = new LinkedList<>();
        for (int i = start; i < dirs.length; i++) {
            if (dirs[i].equals(".") || dirs[i].equals(""))
                continue;
            if (dirs[i].equals("..")) {
                if (list.size() != 0)
                    list.removeLast();
                continue;
            }
            list.add(dirs[i]);
        }
        if (list.size() == 0) {
            return "/";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : list) {
            stringBuffer.append("/").append(s);
        }
        return stringBuffer.toString();
    }
}
