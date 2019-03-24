package com.ben.leetcode.dp;

import java.util.*;

//need more care
public class _139_Word_Break {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            Set<String> map = new HashSet<>(wordDict);

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    //s.substring(0,j) is valid, and s.substring(j,i) is in dict. so it is valid
                    if (dp[j] && map.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
