
// 516. Longest Palindromic Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-26 17:59:42
 * @url:https://leetcode.com/problems/longest-palindromic-subsequence/#/description
 */

public class Solution {
    private int len;

    public int longestPalindromeSubseq(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        len = s.length();
        int dp[][] = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}