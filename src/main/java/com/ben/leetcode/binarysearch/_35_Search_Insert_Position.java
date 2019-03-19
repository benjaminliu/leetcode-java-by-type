package com.ben.leetcode.binarysearch;

public class _35_Search_Insert_Position {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            if (n == 0)
                return 0;

            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target)
                    return mid;

                if (nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            return left;
        }
    }
}
