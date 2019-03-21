package com.ben.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//hard
public class _30_Substring_with_Concatenation_of_All_Words {

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            if (s.length() == 0)
                return res;
            if (words.length == 0)
                return res;
            int n = s.length();
            int num = words.length;
            int len = words[0].length();
            int totalLen = num * len;
            if (n < totalLen)
                return res;

            Map<String, Integer> map = new HashMap<String, Integer>();
            resetMap(map, words);

            for (int i = 0, end = n - totalLen + 1; i < end; i++) {
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                while (j < num) {
                    String word = s.substring(i + j * len, i + (j + 1) * len);
                    if (map.containsKey(word)) {
                        seen.put(word, seen.getOrDefault(word, 0) + 1);
                        if (seen.get(word) > map.getOrDefault(word, 0)) {
                            break;
                        }
                    } else {
                        break;
                    }
                    j++;
                }
                if (j == num) {
                    res.add(i);
                }
            }
            return res;
        }

        private void resetMap(Map<String, Integer> map, String[] words) {
            for (final String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
