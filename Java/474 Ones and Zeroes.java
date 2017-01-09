
// 474. Ones and Zeroes

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-9 12:10:01
 * @url:https://leetcode.com/problems/ones-and-zeroes/
 */

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String str : strs) {
            int wordLen = str.length();
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < wordLen; j++) {
                if (str.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}