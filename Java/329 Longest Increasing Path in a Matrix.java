
// 329. Longest Increasing Path in a Matrix

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-07 15:02:45
 * @url:https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */

public class Solution {
    private int[][] step = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int maxArr[][];

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0) {
            return max;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        maxArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, m, n, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int m, int n, int x, int y) {
        if (maxArr[x][y] != 0) {
            return maxArr[x][y];
        }
        int currentMax = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + step[i][0];
            int newY = y + step[i][1];
            if (newX >= 0 && newX < m
                    && newY >= 0 && newY < n
                    && matrix[newX][newY] > matrix[x][y]) {
                currentMax = Math.max(currentMax, dfs(matrix, m, n, newX, newY));
            }
        }
        maxArr[x][y] = 1 + currentMax;
        return maxArr[x][y];
    }
}