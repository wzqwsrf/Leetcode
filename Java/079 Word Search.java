
// Word Search

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:10:34
 * @url:https://leetcode.com/problems/word-search/
 */

public class Solution {

    private int stepArr[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n, len;
    private int visit[][];

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        if (len > m * n) {
            return false;
        }
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char board[][], String word,
                        int startx, int starty, int k) {
        if (startx < 0 || startx >= m
                || starty < 0 || starty >= n
                || visit[startx][starty] == 1) {
            return false;
        }
        if (board[startx][starty] != word.charAt(k)) {
            return false;
        }
        if (k == len - 1) {
            return true;
        }
        visit[startx][starty] = 1;
        boolean flag = dfs(board, word, startx - 1, starty, k + 1)
                || dfs(board, word, startx + 1, starty, k + 1)
                || dfs(board, word, startx, starty - 1, k + 1)
                || dfs(board, word, startx, starty + 1, k + 1);
        visit[startx][starty] = 0;
        return flag;
    }
}