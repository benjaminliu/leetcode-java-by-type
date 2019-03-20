package com.ben.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null)
                return right;

            if (right == null)
                return left;

            return root;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null)
                return null;

            if (p.val == q.val)
                return p;

            if (root.val == p.val)
                return p;

            if (root.val == q.val)
                return q;

            List<TreeNode> pathP = new ArrayList<>();
            pathP.add(root);
            findPath(root, p, pathP);

            List<TreeNode> pathQ = new ArrayList<>();
            pathQ.add(root);
            findPath(root, q, pathQ);

            int n = Math.min(pathP.size(), pathQ.size());
            int i = 0;
            for (; i < n; i++) {
                if (pathQ.get(i) != pathP.get(i)) {
                    return pathQ.get(i - 1);
                }
            }
            return pathQ.get(i - 1);
        }

        private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {

            if (root.val == p.val) {
                return true;
            }

            if (root.left != null) {
                path.add(root.left);
                if (findPath(root.left, p, path))
                    return true;
                path.remove(path.size() - 1);
            }

            if (root.right != null) {
                path.add(root.right);
                if (findPath(root.right, p, path))
                    return true;
                path.remove(path.size() - 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution solution = new Solution();


        System.out.println(solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
    }
}
