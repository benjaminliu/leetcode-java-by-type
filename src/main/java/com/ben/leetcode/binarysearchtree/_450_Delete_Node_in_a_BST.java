package com.ben.leetcode.binarysearchtree;

public class _450_Delete_Node_in_a_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (key < root.val)
                root.left = deleteNode(root.left, key);
            else if (key > root.val)
                root.right = deleteNode(root.right, key);
            else {
                if (root.left == null)
                    return root.right;
                if (root.right == null)
                    return root.left;

                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        }

        private TreeNode findMin(TreeNode node) {
            while (node.left != null)
                node = node.left;

            return node;
        }
    }
}
