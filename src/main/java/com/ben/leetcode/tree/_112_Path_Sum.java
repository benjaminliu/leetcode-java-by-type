package com.ben.leetcode.tree;

public class _112_Path_Sum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            return helper(root, 0, sum);
        }

        private boolean helper(TreeNode root, int temp, int sum) {
            temp += root.val;
            if (root.left == null && root.right == null)
                return temp == sum;

            if (root.left != null) {
                if (helper(root.left, temp, sum)) {
                    return true;
                }
            }

            if (root.right != null) {
                if (helper(root.right, temp, sum)) {
                    return true;
                }
            }
            return false;
        }

    }
}
