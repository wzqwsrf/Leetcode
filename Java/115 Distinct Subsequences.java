
// Distinct Subsequences

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:11:38
 * @url:https://leetcode.com/problems/distinct-subsequences/
 */

public class Solution {

    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        if (len1 < len2) {
            return 0;
        }
        int dp[][] = new int[len2 + 1][len1 + 1];
        for (int i = 0; i < len2; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < len1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len2][len1];
    }
}