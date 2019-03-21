package com.ben.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    static class Solution {
        private final char left = '(';
        private final char right = ')';

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n < 1)
                return res;

            helper(res, n, n, new StringBuilder());

            return res;
        }

        private void helper(List<String> res, int n, int n1, StringBuilder sb) {
            if (n > n1)
                return;
            if (n == 0) {
                while (n1 > 0) {
                    sb.append(right);
                    n1--;
                }
                res.add(sb.toString());
                return;
            }

            int length = sb.length();

            sb.append(left);
            helper(res, n - 1, n1, sb);
            sb.setLength(length);

            sb.append(right);
            helper(res, n, n1 - 1, sb);
            sb.setLength(length);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        for (String s : res)
            System.out.println(s);
    }
}
