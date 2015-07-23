
// Search a 2D Matrix II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-23 10:54:35
 * @url:https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}