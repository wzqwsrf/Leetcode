
//Word Break II

import java.util.*;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月20日21:06:57
 * @url:https://leetcode.com/problems/word-break-ii/
 */

public class Word_Break_II {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        if (wordDict == null || wordDict.size() == 0) {
            return list;
        }
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        Arrays.fill(dp, true);
        dfs(list, dp, s, wordDict, 0, "");
        return list;
    }

    private void dfs(List<String> list, boolean dp[], String s,
                     Set<String> wordDict, int start, String word) {
        if (start == s.length()) {
            list.add(word.trim());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if (wordDict.contains(prefix) && dp[i + 1]) {
                String newWord = word + " " + prefix;
                int size = list.size();
                dfs(list, dp, s, wordDict, i + 1, newWord);
                if (size == list.size()) {
                    dp[i + 1] = false;
                }
            }
        }
    }
}