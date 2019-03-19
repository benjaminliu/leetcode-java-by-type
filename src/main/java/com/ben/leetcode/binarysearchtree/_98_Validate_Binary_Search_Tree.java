package com.ben.leetcode.binarysearchtree;

public class _98_Validate_Binary_Search_Tree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;

            if (root.left == null && root.right == null)
                return true;

            return helper(root, (long) Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
        }

        private boolean helper(TreeNode root, long min, long max) {
            if (root.val <= min)
                return false;

            if (root.val >= max)
                return false;

            if (root.left != null) {
                if (helper(root.left, min, root.val) == false)
                    return false;
            }

            if (root.right != null) {
                if (helper(root.right, root.val, max) == false)
                    return false;
            }
            return true;
        }
    }
}
