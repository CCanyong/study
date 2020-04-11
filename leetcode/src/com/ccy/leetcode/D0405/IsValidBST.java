package com.ccy.leetcode.D0405;

import com.ccy.leetcode.common.TreeNode;

/**
 * 验证二叉树
 * leetcode: 98
 * 难度: 中等
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return back(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }


    private boolean back(TreeNode root, long max, long min) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean b1 = true;
        boolean b2 = true;
        if (left != null) {
            if (left.val >= root.val || left.val <= min) {
                return false;
            }
            b1 = back(left, root.val, min);
        }
        if (right != null) {
            if (right.val <= root.val || right.val >= max) {
                return false;
            }
            b2 = back(right, max, root.val);
        }
        return b1 & b2;
    }

}
