package com.ben.leetcode.dp;

public class _70_Climbing_Stairs {
    static class Solution {
        public int climbStairs(int n) {
            if (n == 1)
                return 1;
            if (n == 2)
                return 2;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }

        //only need pre, and the one before pre
        public int climbStairs1(int n) {
            if (n == 1)
                return 1;
            if (n == 2)
                return 2;

            int prepre = 1;
            int pre = 2;
            int cur = pre;
            for (int i = 2; i < n; i++) {
                cur = pre + prepre;
                prepre = pre;
                pre = cur;
            }
            return cur;
        }
    }
}
