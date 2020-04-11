package com.ccy.leetcode.D0406;

import com.ccy.leetcode.common.TreeNode;
import com.sun.source.tree.Tree;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return back(0, preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode back(int index, int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(inorder[start]);
        }
        TreeNode treeNode = new TreeNode(preorder[index]);
        int tmp = start;
        for (int i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                tmp = i;
            }
        }
        treeNode.left = back(index + 1, preorder, inorder, start, tmp - 1);
        treeNode.right = back(index + tmp + 1 - start, preorder, inorder, tmp + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = new BuildTree().buildTree(preorder, inorder);

    }
}
