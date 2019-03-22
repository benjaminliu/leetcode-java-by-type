package com.ben.leetcode.dfs_bfs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _698_Partition_to_K_Equal_Sum_Subsets {
    static class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k <= 0)
                return false;

            int sum = 0;
            for (int n : nums)
                sum += n;

            if (sum % k != 0)
                return false;

            int target = sum / k;

            int[] visited = new int[nums.length];
            return canPartition(nums, visited, 0, k, 0, 0, target);
        }

        private boolean canPartition(int[] nums, int[] visited, int startIdx, int k, int curSum, int curNum, int target) {
            if (k == 1)
                return true;

            if (curSum > target)
                return false;

            // We find a group, start to find the next group
            if (curSum == target && curNum > 0)
                return canPartition(nums, visited, 0, k - 1, 0, 0, target);

            for (int i = startIdx; i < nums.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    if (canPartition(nums, visited, i + 1, k, curSum + nums[i], curNum++, target))
                        return true;
                    visited[i] = 0;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
