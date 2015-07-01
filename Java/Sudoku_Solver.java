
// Sudoku Solver

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日22:48:13
 * @url:https://oj.leetcode.com/problems/sudoku-solver/
 * 每个数填1到9，判断是否符合要求，回溯寻找结果
 * 具体参考http://blog.csdn.net/u013027996/article/details/43499949
 */

import java.util.ArrayList;

public class Solution {

    public int n, size;
    public ArrayList<Integer> list;

    public void solveSudoku(char[][] board) {
        n = board.length;
        list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                }
            }
        }
        size = list.size();
        dfs(board, 0);
    }

    public boolean dfs(char[][] board, int cur) {
        if (cur == size) {
            return true;
        }
        int index = list.get(cur);
        int row = index / n;
        int col = index % n;
        for (int i = 1; i <= 9; i++) {
            if (isValidSudoku(board, row, col, (char) (i + '0'))) {
                board[row][col] = (char) (i + '0');
                if (dfs(board, cur + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board, int i, int j, Character value) {
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            if (board[i][k] == value) {
                // System.out.println("1 "+i+" "+j );
                return false;
            }
        }
        for (int k = 0; k < n; k++) {
            if (k == i) {
                continue;
            }
            if (board[k][j] == value) {
                // System.out.println("2 "+i+" "+j );
                return false;
            }
        }
        int rowStart = i / 3 * 3;
        int rowEnd = rowStart + 3;
        int colStart = j / 3 * 3;
        int colEnd = colStart + 3;
        for (int k = rowStart; k < rowEnd; k++) {
            for (int l = colStart; l < colEnd; l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (board[k][l] == value) {
                    // System.out.println("3 "+i+" "+j );
                    return false;
                }
            }
        }
        return true;
    }
}
