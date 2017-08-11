
// 498. Diagonal Traverse

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-11 13:18:22
 * @url:https://leetcode.com/problems/diagonal-traverse/description/
 */

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        if (m == 1) {
            return matrix[0];
        }
        int array[] = new int[m * n];
        int i = 0;
        int j = 0;
        int k = 1;
        array[0] = matrix[0][0];
        boolean flag = true;
        while (k < m * n) {
            if (flag) {
                if (j + 1 < n) {
                    j += 1;
                } else if (i + 1 < m) {
                    i += 1;
                }
                while (i < m && j >= 0) {
                    array[k] = matrix[i][j];
                    i += 1;
                    j -= 1;
                    k++;
                }
                i -= 1;
                j += 1;
                flag = false;
            } else {
                if (i + 1 < m) {
                    i += 1;
                } else if (j + 1 < n) {
                    j += 1;
                }
                while (i >= 0 && j < n) {
                    array[k] = matrix[i][j];
                    i -= 1;
                    j += 1;
                    k++;
                }
                i += 1;
                j -= 1;
                flag = true;
            }
        }
        return array;
    }
}