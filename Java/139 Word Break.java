
// Word Break

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月20日21:08:10
 * @url:https://leetcode.com/problems/word-break/
 */

import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return false;
        }
        if (dict.contains(s)) {
            return true;
        }
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String tempStr = s.substring(j, i);
                if (dp[j] && dict.contains(tempStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}