package com.ben.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class _102_Binary_Tree_Level_Order_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            res.clear();

            if (root != null)
                helper(root, 0);
            return res;
        }

        private void helper(TreeNode root, int deep) {
            if (deep == res.size()) {
                res.add(new ArrayList<>());
            }

            res.get(deep).add(root.val);

            if (root.left != null)
                helper(root.left, deep + 1);

            if (root.right != null)
                helper(root.right, deep + 1);
        }


    }
}
