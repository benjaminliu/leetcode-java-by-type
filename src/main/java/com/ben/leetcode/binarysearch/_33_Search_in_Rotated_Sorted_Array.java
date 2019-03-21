package com.ben.leetcode.binarysearch;

public class _33_Search_in_Rotated_Sorted_Array {
    static class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0)
                return -1;

            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target)
                    return mid;

                if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{3, 5, 1}, 3));
//        System.out.println(solution.dfs_bfs(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
