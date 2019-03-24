package com.ben.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s.length() == 0)
                return res;

            helper(s, 0, s.length(), res, new ArrayList<>());
            return res;
        }

        private void helper(String s, int idx, int length, List<List<String>> res, ArrayList<String> group) {
            if (idx == length) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i = idx; i < length; i++) {
                if (isPalindrome(s, idx, i)) {
                    group.add(s.substring(idx, i + 1));
                    helper(s, i + 1, length, res, group);
                    group.remove(group.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }

}
