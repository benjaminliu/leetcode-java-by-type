package com.ben.leetcode.binarysearch;

public class _69_Sqrt_x {
    static class Solution {
        public int mySqrt(int x) {
            if (x == 0)
                return 0;
            if (x == 1)
                return 1;

            int left = 1, right = x;
            while (true) {
                int mid = left + (right - left) / 2;
                if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    if (mid + 1 > x / (mid + 1))
                        return mid;
                    left = mid + 1;
                }
            }
        }

        public int mySqrt1(int x) {
            if (x == 0)
                return 0;
            if (x == 1)
                return 1;

            int left = 1, right = x;
            int res = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid <= x / mid) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8));
    }
}
