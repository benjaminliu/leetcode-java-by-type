package com.ben.leetcode.binarysearch;

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    static class Solution {

        //找到 小于等于 中间数的  数量， 如果大于K，  right = mid, 如果小于K left = mid + 1
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0], right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                int j = n - 1;
                for (int i = 0; i < n; i++) {
                    while (j >= 0 && matrix[i][j] > mid)
                        j--;
                    count += (j + 1);
                }
                if (count < k)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }
}
