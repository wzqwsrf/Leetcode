
// 463. Island Perimeter

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-23 11:03:19
 * @url:https://leetcode.com/problems/island-perimeter/description/
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i != 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j != 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }
}