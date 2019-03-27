package com.ben.leetcode.dp;

public class _813_Largest_Sum_of_Averages {
    static class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            int len = A.length;
            double[][] memo = new double[len + 1][len + 1];
            double cur = 0;
            for (int i = 0; i < len; i++) {
                cur += A[i];
                memo[i + 1][1] = cur / (i + 1);
            }
            return search(len, K, A, memo);
        }

        private double search(int n, int k, int[] a, double[][] memo) {
            if (memo[n][k] > 0)
                return memo[n][k];
            if (n < k)
                return 0;

            double cur = 0;
            for (int i = n - 1; i > 0; i--) {
                cur += a[i];
                memo[n][k] = Math.max(memo[n][k], search(i, k - 1, a, memo) + cur / (n - i));
            }
            return memo[n][k];
        }
    }
}
