package com.ben.leetcode.dp;

public class _62_Unique_Paths {
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[n - 1][m - 1];
        }

        //we only need last row, and cur row
        public int uniquePaths1(int m, int n) {
            int[] cur = new int[m];
            int[] last = new int[m];
            for (int i = 0; i < m; i++) {
                last[i] = 1;
            }

            cur[0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    cur[j] = cur[j - 1] + last[j];
                }

                int[] temp = cur;
                cur = last;
                last = temp;
            }
            return last[m - 1];
        }

        //cur[j] is last[j] before update
        public int uniquePaths2(int m, int n) {
            int[] cur = new int[m];
            for (int i = 0; i < m; i++) {
                cur[i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    cur[j] = cur[j - 1] + cur[j];
                }
            }
            return cur[m - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths1(3, 2));
    }
}
