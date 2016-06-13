
// 322. Coin Change

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-13 12:31:00
 * @url:https://leetcode.com/problems/coin-change/
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int dp[] = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i]) {
                    continue;
                }
                if (dp[j - coins[i]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}