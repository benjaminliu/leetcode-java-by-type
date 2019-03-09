package com.ben.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null)
                return 0;
            int n = s.length();
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 1;
            int left = 0;
            int right = 1;
            map.put(s.charAt(0), 0);
            while (right < n) {
                char c = s.charAt(right);
                Integer idx = map.get(c);
                if (idx == null) {
                } else {
                    int len = right - left;
                    if (len > max)
                        max = len;
                    while (left <= idx) {
                        map.remove(left);
                        left++;
                    }
                }
                map.put(c, right);
                right++;
            }
            int len = right - left;
            if (len > max)
                max = len;
            return max;
        }

        public int lengthOfLongestSubstring1(String s) {
            if (s == null)
                return 0;
            int n = s.length();
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;

            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int left = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                Integer idx = map.get(c);
                if (idx != null) {
                    left = Math.max(left, idx + 1);
                }
                map.put(c, i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }

        public int lengthOfLongestSubstring2(String s) {
            if (s == null)
                return 0;
            int n = s.length();
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            int[] map = new int[128];
            int left = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int idx = map[c];
                left = Math.max(left, idx);
                max = Math.max(max, i - left + 1);
                map[c] = i + 1;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }
}
