package com.ccy.leetcode.D0410;

/**
 * 插入区间
 * leetcode: 57
 * 难度: 困难
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //List<int[2]>tmp = new ArrayList();
        int start = get(intervals, newInterval[0], 0, intervals.length);
        int end = get(intervals, newInterval[1], 0, intervals.length);
        System.out.println(start + " " + end);
        if (end == start) {
            int[][] res = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, res, 0, start);
            res[start] = newInterval;
            System.arraycopy(intervals, start, res, start + 1, intervals.length - 1);
            return res;
        }
        int len = 0;
        int left = 0;
        if (intervals[start][0] < newInterval[0]) {
            left = intervals[start][0];
        } else {
            left = newInterval[0];
        }
        int right = 0;
        if (intervals[end][0] <= newInterval[1]) {
            right = intervals[end][1];

        } else {
            right = newInterval[1];
            end = end - 1;
        }
        len = end - start + 1;
        int[][] res = new int[intervals.length - len + 1][2];
        System.arraycopy(intervals, 0, res, 0, start - 1);
        res[start][0] = left;
        res[end][1] = right;
        System.arraycopy(intervals, end + 1, res, start + 1, res.length);
        return res;
    }

    int get(int[][] arr, int val, int i, int j) {
        if (i <= j) {
            return i;
        }
        int mid = (i + j) / 2;
        if (arr[mid][1] > val) {
            return get(arr, val, i, j - 1);
        } else if (arr[mid][1] < val) {
            return get(arr, val, mid, j);
        } else {
            return i;
        }
    }
}
