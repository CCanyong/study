package com.ccy.leetcode.D0405;

import com.ccy.leetcode.common.TreeNode;

/**
 * 是否相同树
 * 难度: 简单
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            boolean b1 = isSameTree(p.left, q.left);
            boolean b2 = isSameTree(p.right, q.right);
            return b1 && b2;
        }
        return false;
    }
}
