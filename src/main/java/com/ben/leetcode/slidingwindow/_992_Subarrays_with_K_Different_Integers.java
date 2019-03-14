package com.ben.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _992_Subarrays_with_K_Different_Integers {
    static class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMostK(A, K) - atMostK(A, K - 1);
        }

        private int atMostK(int[] a, int k) {
            int left = 0, res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int right = 0; right < a.length; right++) {
                int v = map.getOrDefault(a[right], 0);
                if (v == 0)
                    k--;
                map.put(a[right], v + 1);
                while (k < 0) {
                    int v1 = map.get(a[left]);
                    v1--;
                    if (v1 == 0)
                        k++;
                    map.put(a[left], v1);
                    left++;
                }
                //the total number of subarrays ending at j that contain at most K distinct.
                res += right - left + 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
