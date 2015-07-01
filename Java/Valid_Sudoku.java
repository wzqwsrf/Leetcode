
// Valid Sudoku

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日18:21:32
 * @url:https://oj.leetcode.com/problems/valid-sudoku/
 * 判断行和列以及每个小格子是否有重复数据
 * 具体参考http://blog.csdn.net/u013027996/article/details/43489683
 */

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (board[i][k] == board[i][j]) {
//                    	System.out.println("1 "+i+" "+j );
                        return false;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (board[k][j] == board[i][j]) {
//                    	System.out.println("2 "+i+" "+j );
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
                        if (board[k][l] == board[i][j]) {
//                        	System.out.println("3 "+i+" "+j );
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
