package com.ben.leetcode.dp;

public class _322_Coin_Change {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0)
                return 0;

            int[] dp = new int[amount + 1];
            int sum = 0;
            while (++sum <= amount) {
                int min = -1;
                for (int coin : coins) {
                    if (sum >= coin) {
                        int temp = dp[sum - coin];
                        if (temp != -1) {
                            //add 1 coin
                            temp++;
                            if (min < 0) {
                                min = temp;
                            } else {
                                min = Math.min(temp, min);
                            }
                        }
                    }
                }
                dp[sum] = min;
            }

            return dp[amount];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }
}
