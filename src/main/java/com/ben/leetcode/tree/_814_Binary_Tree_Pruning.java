package com.ben.leetcode.tree;

public class _814_Binary_Tree_Pruning {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null)
                return null;

            if (root.left != null)
                root.left = pruneTree(root.left);

            if (root.right != null)
                root.right = pruneTree(root.right);

            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }

            return root;
        }
    }
}
