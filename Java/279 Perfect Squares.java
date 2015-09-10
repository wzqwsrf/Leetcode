
// Perfect Squares

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-10 12:55:44
 * @url:https://leetcode.com/problems/perfect-squares/
 */

public class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}