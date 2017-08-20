
// 661. Image Smoother

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-20 18:22:03
 * @url:https://leetcode.com/problems/image-smoother/description/
 */

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] array = new int[m][n];
        int stepArr[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 1;
                int sum = M[i][j];
                for (int k = 0; k < 8; k++) {
                    int newX = i + stepArr[k][0];
                    int newY = j + stepArr[k][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    sum += M[newX][newY];
                    count++;
                }
                array[i][j] = sum / count;
            }
        }
        return array;
    }
}