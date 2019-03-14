package com.ben.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _567_Permutation_in_String {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n2 = s2.length(), n1 = s1.length();

            if (n2 < n1)
                return false;

            Map<Character, Integer> map = new HashMap<>();
            for (char c : s1.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int counter = n1;
            while (right < n2) {
                char c1 = s2.charAt(right);
                Integer i1 = map.get(c1);
                if (i1 == null) {
                    right++;
                    continue;
                }
                if (i1 > 0)
                    counter--;

                map.put(c1, i1 - 1);
                right++;

                while (counter == 0) {
                    if (right - left == n1)
                        return true;

                    char c2 = s2.charAt(left);
                    Integer i2 = map.get(c2);
                    if (i2 == null) {
                        left++;
                        continue;
                    }
                    if (i2 >= 0)
                        counter++;

                    map.put(c2, i2 + 1);
                    left++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
        System.out.println(solution.checkInclusion("ab", "deabdd"));
    }
}
