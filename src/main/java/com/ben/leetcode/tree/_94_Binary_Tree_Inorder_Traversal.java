package com.ben.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class _94_Binary_Tree_Inorder_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> res = new ArrayList<>();

            if (root != null)
                helper(root, res);

            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root.left != null)
                helper(root.left, res);

            res.add(root.val);

            if (root.right != null)
                helper(root.right, res);
        }


    }
}
