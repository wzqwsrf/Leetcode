
// 526. Beautiful Arrangement

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-8 21:39:07
 * @url:https://leetcode.com/problems/beautiful-arrangement/description/
 */

class Solution {
    private int count;

    public int countArrangement(int N) {
        count = 0;
        dfs(N, N, new int[N + 1]);
        return count;
    }

    private void dfs(int N, int currNum, int[] visited) {
        if (currNum == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && (i % currNum == 0 || currNum % i == 0)) {
                visited[i] = 1;
                dfs(N, currNum - 1, visited);
                visited[i] = 0;
            }
        }
    }
}