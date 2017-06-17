
// 547. Friend Circles

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-17 15:39:49
 * @url:https://leetcode.com/problems/friend-circles/#/description
 */

public class Solution {
    private int n;
    private int visited[];

    public int findCircleNum(int[][] M) {
        n = M.length;
        visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i) {
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, j);
            }
        }
    }
}