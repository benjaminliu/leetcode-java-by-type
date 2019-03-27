package com.ben.leetcode.dp;

import java.util.Arrays;

public class _688_Knight_Probability_in_Chessboard {
    static class Solution {

        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

        public double knightProbability(int N, int K, int r, int c) {
            int len = N;
            double[][] dp = new double[len][len];
            dp[r][c] = 1;

            for (int k = 0; k < K; k++) {
                double[][] dp2 = new double[len][len];
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        for (int[] dir : moves) {
                            int x = i + dir[0];
                            int y = j + dir[1];

                            //out of board
                            if (x < 0 || x >= len || y < 0 || y >= len)
                                continue;

                            dp2[i][j] += dp[x][y];
                        }
                    }
                }
                dp = dp2;
            }
            double count = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    count += dp[i][j];
                }
            }
            return count / Math.pow(8, K);
        }
    }

}
