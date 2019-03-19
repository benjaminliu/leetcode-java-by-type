package com.ben.leetcode.binarysearch;

import java.util.Arrays;

public class _719_Find_K_th_Smallest_Pair_Distance {
    static class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int low = nums[1] - nums[0];
            for (int i = 1, end = n - 1; i < end; i++)
                low = Math.min(low, nums[i + 1] - nums[1]);

            int high = nums[n - 1] - nums[0];
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (countPair(nums, mid) < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private int countPair(int[] nums, int mid) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += upperBound(nums, i, n - 1, nums[i] + mid) - i - 1;
            }
            return res;
        }

        // Returns index of first index of element which is greater than key
        private int upperBound(int[] nums, int low, int high, int key) {
            if (nums[high] <= key)
                return high + 1;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (key >= nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }


        public int smallestDistancePair1(int[] nums, int k) {
            Arrays.sort(nums);

            int lo = 0;
            int hi = nums[nums.length - 1] - nums[0];
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int count = 0, left = 0;
                for (int right = 0; right < nums.length; ++right) {
                    while (nums[right] - nums[left] > mid)
                        left++;
                    count += right - left;
                }
                //count = number of pairs with distance <= mi
                if (count >= k) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }
    }
}
