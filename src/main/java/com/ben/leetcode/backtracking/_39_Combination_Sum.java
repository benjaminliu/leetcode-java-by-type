package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_Combination_Sum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates.length == 0)
                return res;

            Arrays.sort(candidates);
            helper(candidates, 0, candidates.length, target, res, new ArrayList<>());

            return res;
        }

        private void helper(int[] nums, int idx, int length, int remain, List<List<Integer>> res, ArrayList<Integer> group) {
            if (remain == 0) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i = idx; i < length; i++) {
                if (remain < nums[i])
                    return;

                group.add(nums[i]);
                // not i + 1 because we can reuse same elements
                helper(nums, i, length, remain - nums[i], res, group);
                group.remove(group.size() - 1);
            }
        }
    }
}
