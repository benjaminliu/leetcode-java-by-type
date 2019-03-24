package com.ben.leetcode.dp;

public class _53_Maximum_Subarray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;

            int max = nums[0];
            int tempMax = nums[0];

            for (int i = 1; i < n; i++) {
                tempMax = Math.max(tempMax + nums[i], nums[i]);
                max = Math.max(max, tempMax);
            }
            return max;
        }

        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;

            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
