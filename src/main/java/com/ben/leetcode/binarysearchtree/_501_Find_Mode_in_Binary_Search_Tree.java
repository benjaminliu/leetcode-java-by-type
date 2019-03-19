package com.ben.leetcode.binarysearchtree;

//todo need more care
public class _501_Find_Mode_in_Binary_Search_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private int curVal;
        private int curCount = 0;
        private int maxCount = 0;
        private int modeCount = 0;

        private int[] modes;

        public int[] findMode(TreeNode root) {
            inorder(root);
            modes = new int[modeCount];
            modeCount = 0;
            curCount = 0;
            inorder(root);
            return modes;
        }

        private void inorder(TreeNode root) {
            if (root == null)
                return;

            inorder(root.left);
            process(root.val);
            inorder(root.right);
        }

        private void process(int val) {
            if (val != curVal) {
                curVal = val;
                curCount = 0;
            }
            curCount++;
            if (curCount > maxCount) {
                maxCount = curCount;
                modeCount = 1;
            } else if (curCount == maxCount) {
                if (modes != null)
                    modes[modeCount] = curVal;
                modeCount++;
            }
        }
    }
}
