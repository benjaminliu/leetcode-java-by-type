package com.ben.leetcode.binarysearchtree;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length;
            if (n == 0)
                return null;

            if (n == 1) {
                return new TreeNode(nums[0]);
            }

            return helper(nums, 0, n - 1);
        }

        private TreeNode helper(int[] nums, int lo, int hi) {
            if (lo > hi)
                return null;

            int mid = lo + (hi - lo) / 2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = helper(nums, lo, mid - 1);
            root.right = helper(nums, mid + 1, hi);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
