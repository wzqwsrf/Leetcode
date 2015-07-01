
// N-Queens II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日17:48:19
 * @url:https://leetcode.com/problems/n-queens-ii/
 */

public class Solution {

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] queen = new int[n + 1];
        count = 0;
        for (int i = 1; i < n + 1; i++) {
            queen[1] = i;
            dfs(queen, 2, n);
        }
        return count;
    }

    public int count;

    public void dfs(int queen[], int line, int n) {
        if (line == n + 1) {
            count++;
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (valid(line, i, queen)) {
                queen[line] = i;
                dfs(queen, line + 1, n);
                queen[line] = 0;
            }
        }
    }

    public boolean valid(int row, int col, int[] queen) {
        for (int i = 1; i < row; i++) {
            if (queen[i] != 0 && (queen[i] == col ||
                    Math.abs(i - row) == Math.abs(queen[i] - col)))
                return false;
        }
        return true;
    }
}