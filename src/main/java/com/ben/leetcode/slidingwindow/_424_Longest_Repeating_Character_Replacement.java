package com.ben.leetcode.slidingwindow;

public class _424_Longest_Repeating_Character_Replacement {
    // 1.Given a string convert it to a string with all same characters with minimal changes
    // length of the entire string - number of times of the maximum occurring character in the string

    // 2.we can apply the at most k changes constraint and maintain a sliding window such that
    // (length of substring - number of times of the maximum occurring character in the substring) <= k
    static class Solution {
        public int characterReplacement(String s, int k) {
            if (s == null || s.length() == 0 || k < 0)
                return 0;

            int n = s.length();
            char[] cs = s.toCharArray();
            int[] map = new int[26];
            int left = 0, right = 0;
            int max = 0;
            while (right < n) {
                char c = cs[right];
                right++;
                map[c - 'A']++;
                while (!isValid(map, k)) {
                    c = cs[left];
                    left++;
                    map[c - 'A']--;
                }
                max = Math.max(max, right - left);
            }
            return max;
        }

        private boolean isValid(int[] map, int k) {
            int max = 0;
            int total = 0;
            for (int i : map) {
                total += i;
                max = Math.max(max, i);
            }
            return total - max <= k;
        }
    }
}
