package com.ben.leetcode.slidingwindow;

/**
 * hard need more care
 */
public class _76_Minimum_Window_Substring {
    static class Solution {
        public String minWindow(String s, String t) {
            int[] map = new int[128];
            for (int i = 0; i < t.length(); i++) {
                map[t.charAt(i)]++;
            }
            int counter = t.length();
            int left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
            while (right < s.length()) {
                char rc = s.charAt(right);
                right++;
                if (map[rc] > 0) {
                    counter--;
                }
                map[rc]--;

                while (counter == 0) {
                    if (right - left < window) {
                        window = right - left;
                        head = left;
                    }
                    char lc = s.charAt(left);
                    left++;
                    if (map[lc] == 0) {
                        counter++;
                    }
                    map[lc]++;
                }
            }
            return head == -1 ? "" : s.substring(head, head + window);
        }
    }
}
