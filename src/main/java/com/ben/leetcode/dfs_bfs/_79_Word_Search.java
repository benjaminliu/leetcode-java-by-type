package com.ben.leetcode.dfs_bfs;

public class _79_Word_Search {

    static class Solution {

        public boolean exist(char[][] board, String word) {
            int row = board.length;
            if (row == 0)
                return false;
            int col = board[0].length;
            if (col == 0)
                return false;

            if (row * col < word.length())
                return false;

            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean helper(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
            if (idx == word.length())
                return true;

            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
                return false;

            if (visited[i][j] == true)
                return false;

            if (word.charAt(idx) != board[i][j])
                return false;

            visited[i][j] = true;

            if (helper(board, word, i - 1, j, idx + 1, visited)
                    || helper(board, word, i + 1, j, idx + 1, visited)
                    || helper(board, word, i, j - 1, idx + 1, visited)
                    || helper(board, word, i, j + 1, idx + 1, visited)) {
                return true;
            }

            visited[i][j] = false;
            return false;
        }

    }
}
