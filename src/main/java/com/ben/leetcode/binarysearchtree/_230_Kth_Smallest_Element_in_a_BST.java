package com.ben.leetcode.binarysearchtree;

public class _230_Kth_Smallest_Element_in_a_BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private int count;
        private Integer value;

        public int kthSmallest(TreeNode root, int k) {
            count = 0;
            value = null;

            dfs(root, k);
            return value;
        }

        private void dfs(TreeNode root, int k) {
            if (value != null)
                return;

            if (root.left != null)
                dfs(root.left, k);

            if (value != null)
                return;

            count++;
            if (count == k) {
                value = root.val;
                return;
            }
            if (root.right != null)
                dfs(root.right, k);
        }
    }
}
