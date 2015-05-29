
//Dungeon Game

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:06:51
 * @url:https://leetcode.com/problems/dungeon-game/
 */

public class Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(0 - dungeon[i][j], 0);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 0);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 0);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i][j + 1],
                            dp[i + 1][j]) - dungeon[i][j], 0);
                }
            }
        }
        return dp[0][0] + 1;
    }
}