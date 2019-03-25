package com.ben.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class _300_Longest_Increasing_Subsequence {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if (n < 2)
                return n;

            List<Integer> group = new ArrayList<>();
            group.add(nums[0]);

            for (int i = 1; i < n; i++) {
                int temp = nums[i];
                if (temp > group.get(group.size() - 1))
                    group.add(temp);
                else if (temp < group.get(0)) {
                    group.set(0, temp);
                } else {
                    int left = 0;
                    int right = group.size() - 1;
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (group.get(mid) < temp) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    group.set(left, temp);
                }
            }
            return group.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101,4}));
    }
}
