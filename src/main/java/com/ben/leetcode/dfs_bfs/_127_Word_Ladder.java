package com.ben.leetcode.dfs_bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//bfs
public class _127_Word_Ladder {

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> dict = new HashSet<>(wordList);

            if (!dict.contains(endWord))
                return 0;

            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();

            int len = 1;

            beginSet.add(beginWord);
            endSet.add(endWord);

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                //make begin smaller
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                Set<String> temp = new HashSet<>();
                for (String word : beginSet) {
                    char[] chs = word.toCharArray();

                    for (int i = 0; i < chs.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char oldChar = chs[i];
                            chs[i] = c;
                            String target = String.valueOf(chs);

                            //connected
                            if (endSet.contains(target)) {
                                return len + 1;
                            }

                            if (dict.contains(target)) {
                                temp.add(target);
                                dict.remove(target);
                            }

                            //change back
                            chs[i] = oldChar;
                        }
                    }
                }
                beginSet = temp;
                len++;
            }
            return 0;
        }
    }
}
