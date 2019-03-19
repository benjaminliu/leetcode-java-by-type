package com.ben.leetcode.binarysearchtree;

public class _700_Search_in_a_Binary_Search_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;

            if (root.val == val)
                return root;

            if (root.val > val)
                return searchBST(root.left, val);


            return searchBST(root.right, val);
        }
    }
}
