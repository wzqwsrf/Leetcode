
//N-Queens 404ms

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日17:45:51
 * @url:https://leetcode.com/problems/n-queens/
 */

public class N_Queens {

    public ArrayList<String[]> solveNQueens(int n) {
        list = new ArrayList<String[]>();
        if (n <= 0) {
            return list;
        }
        int[] queen = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            queen[1] = i;
            dfs(queen, 2, n);
        }
        return list;
    }

    public ArrayList<String[]> list;

    public void dfs(int queen[], int line, int n) {
        if (line == n + 1) {
            String[] tempArr = new String[n];
            for (int i = 1; i < n + 1; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 1; j < n + 1; j++) {
                    if (queen[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tempArr[i - 1] = sb.toString();
            }
            list.add(tempArr);
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