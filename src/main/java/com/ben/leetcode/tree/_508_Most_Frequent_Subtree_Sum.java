package com.ben.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _508_Most_Frequent_Subtree_Sum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private Map<Integer, Integer> countMap;
        private Integer maxCount;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null)
                return new int[0];

            countMap = new HashMap<>();
            maxCount = 0;

            helper(root);

            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxCount) {
                    res.add(entry.getKey());
                }
            }

            int[] arr = new int[res.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        private int helper(TreeNode root) {
            int left = 0;
            int right = 0;
            if (root.left != null) {
                left = helper(root.left);
            }
            if (root.right != null) {
                right = helper(root.right);
            }

            int sum = left + right + root.val;
            int count = countMap.getOrDefault(sum, 0);
            count++;
            countMap.put(sum, count);
            if (count > maxCount)
                maxCount = count;
            return sum;
        }
    }
}
