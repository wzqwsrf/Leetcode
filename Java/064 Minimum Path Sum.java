
// Minimum Path Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日18:01:17
 * @url:https://leetcode.com/problems/minimum-path-sum/
 */

public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1 && j >= 1) {
                    int num1 = dp[i][j - 1] + grid[i][j];
                    int num2 = dp[i - 1][j] + grid[i][j];
                    int num3 = dp[i - 1][j - 1]
                            + Math.min(grid[i - 1][j], grid[i][j - 1])
                            + grid[i][j];
                    dp[i][j] = Math.min(Math.min(num1, num2), num3);
                } else if (i >= 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j >= 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}