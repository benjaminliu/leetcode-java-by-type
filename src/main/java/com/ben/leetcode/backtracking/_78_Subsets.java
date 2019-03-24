package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) {
                return res;
            }

            helper(nums, 0, nums.length, res, new ArrayList<>());

            return res;
        }

        private void helper(int[] nums, int idx, int length, List<List<Integer>> res, ArrayList<Integer> group) {

            res.add(new ArrayList<>(group));

            if (idx >= length)
                return;

            for (int i = idx; i < length; i++) {
                group.add(nums[i]);
                helper(nums, i + 1, length, res, group);
                group.remove(group.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(new int[]{1, 2, 3});

        for (List<Integer> group : res) {
            for (Integer i : group) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
