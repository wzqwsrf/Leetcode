
// Burst Balloons

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-30 19:28:41
 * @url:https://leetcode.com/problems/burst-balloons/
 */

public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int newNums[] = new int[len + 2];
        int n = 1;
        for (int num : nums) {
            newNums[n++] = num;
        }
        newNums[n++] = 1;
        newNums[0] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++)
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++)
                    dp[left][right] = Math.max(
                            dp[left][right],
                            newNums[left] * newNums[i] * newNums[right]
                                    + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}