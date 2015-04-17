
//ZigZag Conversion 404ms

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月17日18:46:49
 * @url:https://leetcode.com/problems/number-of-islands/
 */

public class Number_of_Islands {
    private int stepArr[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int visit[][];
    private int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visit[i][j] == 0) {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char grid[][], int i, int j) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i * n + j);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;

            for (int k = 0; k < 4; k++) {
                int newX = x + stepArr[k][0];
                int newY = y + stepArr[k][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && grid[newX][newY] == '1' && visit[newX][newY] == 0) {
                    queue.add(newX * n + newY);
                    visit[newX][newY] = 1;
                }
            }
        }
    }
}