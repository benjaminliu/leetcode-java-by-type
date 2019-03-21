package com.ben.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phone_Number {


    class Solution {

        private char[][] map = new char[][]{
                {'0'},
                {'1'},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new LinkedList<>();
            if (digits.isEmpty())
                return res;

            res.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (((LinkedList<String>) res).peek().length() == i) {
                    String temp = ((LinkedList<String>) res).remove();
                    for (char c : map[x]) {
                        res.add(temp + c);
                    }
                }
            }
            return res;
        }

        public List<String> letterCombinations1(String digits) {
            LinkedList<String> res = new LinkedList<String>();
            if (digits.isEmpty()) return res;
            res.add("");
            while (res.peek().length() != digits.length()) {
                String remove = res.remove();
                for (char c : map[digits.charAt(remove.length()) - '0']) {
                    res.addLast(remove + c);
                }
            }
            return res;
        }

        public List<String> letterCombinations2(String digits) {
            List<String> res = new ArrayList();
            if (digits == null || digits.length() == 0)
                return res;

            letterHelper(res, digits, "", 0);
            return res;
        }

        public void letterHelper(List<String> res, String d, String pre, int start) {
            if (pre.length() == d.length()) {
                res.add(pre);
                return;
            }
            char[] temp = map[d.charAt(start) - '0'];
            for (int i = 0; i < temp.length; i++) {
                letterHelper(res, d, pre + temp[i], start + 1);
            }
        }
    }
}
