package com.ben.leetcode.binarysearch;

public class _74_Search_a_2D_Matrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0)
                return false;

            int col = matrix[0].length;
            if (col == 0)
                return false;
            if (target < matrix[0][0])
                return false;
            if (target > matrix[row - 1][col - 1])
                return false;

            int left = 0, right = row * col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int r = mid / col;
                int c = mid % col;
                if (matrix[r][c] == target)
                    return true;
                if (matrix[r][c] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            return false;
        }
    }
}
