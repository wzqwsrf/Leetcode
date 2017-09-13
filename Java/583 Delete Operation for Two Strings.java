
// 583. Delete Operation for Two Strings

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-13 12:00:31
 * @url:https://leetcode.com/problems/delete-operation-for-two-strings/description/
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}