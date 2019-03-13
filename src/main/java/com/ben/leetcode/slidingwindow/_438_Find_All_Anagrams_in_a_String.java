package com.ben.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438_Find_All_Anagrams_in_a_String {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int ns = s.length();
            int np = p.length();
            if (ns < np)
                return new ArrayList<>();

            int[] map = new int[26];

            for (int i = 0; i < np; i++) {
                int t = c2i(p.charAt(i));
                map[t]++;
            }
            int right = 0;
            int[] targetMap = new int[26];
            while (right < np) {
                int t = c2i(s.charAt(right));
                targetMap[t]++;
                right++;
            }

            List<Integer> res = new ArrayList<>();
            if (isSame(map, targetMap)) {
                res.add(0);
            }

            int left = 0;
            while (right < ns) {
                targetMap[c2i(s.charAt(right))]++;
                targetMap[c2i(s.charAt(left))]--;
                right++;
                left++;
                if (isSame(map, targetMap))
                    res.add(left);
            }

            return res;
        }

        private boolean isSame(int[] map, int[] targetMap) {
            for (int i = 0; i < 26; i++) {
                if (map[i] != targetMap[i])
                    return false;
            }
            return true;
        }

        private int c2i(char c) {
            return c - 'a';
        }


        public List<Integer> findAnagrams1(String s, String p) {
            int ns = s.length();
            int np = p.length();
            if (ns < np)
                return new ArrayList<>();

            Map<Character, Integer> map = new HashMap<>();
            for (char c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int counter = map.size();
            int left = 0, right = 0;

            List<Integer> res = new ArrayList<>();

            while (right < ns) {
                char c = s.charAt(right);
                Integer value = map.get(c);
                if (value != null) {
                    value--;
                    map.put(c, value);

                    if (value == 0)
                        counter--;
                }
                right++;

                while (counter == 0) {
                    if (right - left == np) {
                        res.add(left);
                    }

                    char tc = s.charAt(left);
                    Integer tValue = map.get(tc);
                    if (tValue != null) {
                        tValue++;
                        map.put(tc, tValue);

                        if (tValue > 0)
                            counter++;
                    }
                    left++;
                }
            }
            return res;
        }

        public List<Integer> findAnagrams2(String s, String p) {
            int ns = s.length();
            int np = p.length();
            if (ns < np)
                return new ArrayList<>();

            int[] map = new int[26];
            for (char c : p.toCharArray())
                map[c2i(c)]++;

            List<Integer> res = new ArrayList<>();
            int left = 0, right = 0, count = np;

            while (right < ns) {
                char c1 = s.charAt(right);
                int t1 = c2i(c1);
                if (map[t1] > 0)
                    count--;
                map[t1]--;
                right++;

                while (count == 0) {
                    if (right - left == np)
                        res.add(left);
                    char c2 = s.charAt(left);
                    int t2 = c2i(c2);
                    if (map[t2] >= 0)
                        count++;
                    map[t2]++;
                    left++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams1("cbaebabacd", "abc"));
    }
}
