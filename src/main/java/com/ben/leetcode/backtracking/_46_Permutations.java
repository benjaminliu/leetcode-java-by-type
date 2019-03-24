package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0)
                return res;

            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
            }

            helper(arr, 0, nums.length, res, new ArrayList<>());

            return res;
        }

        private void helper(Integer[] nums, int idx, int length, List<List<Integer>> res, ArrayList<Integer> group) {
            if (group.size() == length) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i = 0; i < length; i++) {
                if (nums[i] == null)
                    continue;
                Integer temp = nums[i];
                nums[i] = null;
                group.add(temp);
                helper(nums, i + 1, length, res, group);
                group.remove(group.size() - 1);
                nums[i] = temp;
            }
        }
    }
}
