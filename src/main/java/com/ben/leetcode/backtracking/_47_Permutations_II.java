package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_Permutations_II {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0)
                return res;

            Arrays.sort(nums);

            helper(nums, 0, nums.length, res, new ArrayList<>(), new boolean[nums.length]);

            return res;
        }

        private void helper(int[] nums, int idx, int length, List<List<Integer>> res, ArrayList<Integer> group, boolean[] used) {
            if (group.size() == length) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i = 0; i < length; i++) {
                if (used[i])
                    continue;
                //remove duplicate,
                //when a number has the same value with its previous, we can use this number only if his previous is used
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                    continue;

                used[i] = true;
                group.add(nums[i]);
                helper(nums, idx + 1, length, res, group, used);
                group.remove(group.size() - 1);
                used[i] = false;
            }
        }
    }
}
