package com.ccy.leetcode.D0405;

import com.ccy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 * leetcode: 103
 * 难度: 中等
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> LStack = new Stack<>();
        Stack<TreeNode> RStack = new Stack<>();
        LStack.push(root);
        while (!LStack.empty()) {
            List t1 = new ArrayList();
            while (!LStack.empty()) {
                TreeNode pop = LStack.pop();
                t1.add(pop.val);
                if (pop.left != null)
                    RStack.push(pop.left);
                if (pop.right != null)
                    RStack.push(pop.right);
            }
            if(!t1.isEmpty())
                res.add(t1);
            List t2 = new ArrayList();
            while (!RStack.empty()) {
                TreeNode pop = RStack.pop();
                t2.add(pop.val);
                if (pop.right != null)
                    LStack.push(pop.right);
                if (pop.left != null)
                    LStack.push(pop.left);

            }
            if(!t2.isEmpty())
                res.add(t2);
        }
        return res;
    }
}
