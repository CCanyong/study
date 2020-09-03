package com.ccy.leetcode.D0831;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 31/08/2020 16:06
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(1);
        l2.add(2);
        l3.add(3);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        boolean b = canVisitAllRooms.canVisitAllRooms(rooms);
        System.out.println(b);

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> keysCache = new HashSet<>();
        Stack<Integer> keys = new Stack<>();
        keys.push(0);
        keysCache.add(0);
        while (!keys.isEmpty()) {
            int key = keys.pop();
            List<Integer> tmp = rooms.get(key);
            for (Integer k : tmp) {
                if (!keysCache.contains(k)) {
                    keys.push(k);
                    keysCache.add(k);
                    if (keysCache.size() == rooms.size())
                        return true;
                }
            }
        }
        return keysCache.size() == rooms.size();
    }
}
