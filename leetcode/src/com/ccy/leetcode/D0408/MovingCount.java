package com.ccy.leetcode.D0408;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 机器人的运动范围
 * leetcode: 面试题13
 * 难度: 中等
 */
public class MovingCount {

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;
        int res = 1;
        int[][] arr = new int[m][n];
        Queue<Node> queue = new ArrayDeque<>();
        arr[0][0] = 1;
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            int x = remove.x;
            int y = remove.y;
            if (x + 1 < m && arr[x + 1][y] == 0
                    && ((x + 1) % 10 + (x + 1) / 10 + y / 10 + y % 10) <= k) {
                queue.add(new Node(x + 1, y));
                arr[x + 1][y] = 1;
                res++;
            }
            if (y + 1 < n && arr[x][y + 1] == 0
                    && ((y + 1) % 10 + (y + 1) / 10 + x / 10 + x % 10) <= k) {
                queue.add(new Node(x, y + 1));
                arr[x][y + 1] = 1;
                res++;
            }

        }
        return res;
    }
}
