package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets_II {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0)
                return res;

            Arrays.sort(nums);

            helper(nums, 0, nums.length, res, new ArrayList<>());
            return res;
        }

        private void helper(int[] nums, int idx, int length, List<List<Integer>> res, ArrayList<Integer> group) {
            res.add(new ArrayList<>(group));

            for (int i = idx; i < length; i++) {
                //remove duplication
                if (i > idx && nums[i] == nums[i - 1])
                    continue;

                group.add(nums[i]);
                helper(nums, i + 1, length, res, group);
                group.remove(group.size() - 1);
            }
        }
    }
}
