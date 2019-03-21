package com.ben.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            backtrack(res,new ArrayList<>(),nums);
            return res;
        }

        private void backtrack(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums) {
            if(tempList.size() == nums.length){
                res.add(new ArrayList<>(tempList));
            }else {
                for(int i =0;i < nums.length;i++){
                    if(tempList.contains(nums[i]))
                        continue;

                    tempList.add(nums[i]);
                    backtrack(res,tempList,nums);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
