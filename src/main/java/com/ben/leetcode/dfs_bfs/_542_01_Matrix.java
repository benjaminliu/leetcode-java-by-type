package com.ben.leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _542_01_Matrix {
    static class Solution {

        private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 0)
                return matrix;
            int col = matrix[0].length;
            if (col == 0)
                return matrix;

            Queue<int[]> queue = new LinkedList<>();

            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0)
                        queue.offer(new int[]{i, j});
                    else
                        matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();

                int temp = matrix[cell[0]][cell[1]] + 1;
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    //not Integer.Max_Value, not visited
                    if (r < 0 || r >= row || c < 0 || c >= col
                            || matrix[r][c] != Integer.MAX_VALUE) {
                        continue;
                    }
                    queue.offer(new int[]{r, c});
                    matrix[r][c] = temp;
                }
            }
            return matrix;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] ints = solution.updateMatrix(new int[][]{{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}});
        int[][] ints = solution.updateMatrix(new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}});
        for (int[] is : ints) {
            for (int i : is)
                System.out.print(i);
            System.out.println();
        }
    }
}
