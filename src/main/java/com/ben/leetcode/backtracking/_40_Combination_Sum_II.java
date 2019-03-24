package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

                if (i > idx && nums[i] == nums[i - 1])
                    continue;

                group.add(nums[i]);
                helper(nums, i + 1, length, remain - nums[i], res, group);
                group.remove(group.size() - 1);
            }
        }
    }

}
