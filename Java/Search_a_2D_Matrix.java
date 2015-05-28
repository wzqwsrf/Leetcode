
//Search a 2D Matrix

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:04:53
 * @url:https://leetcode.com/problems/search-a-2d-matrix/
 */

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int array[] = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[k] = matrix[i][j];
                k++;
            }
        }
        return findT(array, target, 0, m * n - 1);
    }

    public boolean findT(int[] array, int t, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] > t) {
                high = mid - 1;
            } else if (array[mid] < t) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}