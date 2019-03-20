package com.ben.leetcode.tree;

public class _129_Sum_Root_to_Leaf_Numbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        private int total;

        public int sumNumbers(TreeNode root) {
            total = 0;
            if (root != null)
                helper(root, 0);

            return total;
        }

        private void helper(TreeNode root, int temp) {
            temp = temp * 10 + root.val;
            if (root.left == null && root.right == null) {
                total += temp;
                return;
            }
            if (root.left != null)
                helper(root.left, temp);

            if (root.right != null)
                helper(root.right, temp);
        }


    }
}
