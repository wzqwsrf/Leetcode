
// Set Matrix Zeroes

import java.util.HashSet;
import java.util.Set;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:03:50
 * @url:https://leetcode.com/problems/set-matrix-zeroes/
 */

public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (Integer rowNum : rowSet) {
            for (int i = 0; i < n; i++) {
                matrix[rowNum][i] = 0;
            }
        }
        for (Integer colNum : colSet) {
            for (int i = 0; i < m; i++) {
                matrix[i][colNum] = 0;
            }
        }
    }
}