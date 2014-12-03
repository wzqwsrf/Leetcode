
// Spiral Matrix 340ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:56:01
 * @url:https://oj.leetcode.com/problems/spiral-matrix/
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36631355
 */

import java.util.ArrayList;

public class Spiral_Matrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> allList = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return allList;
        }
        allList = printfMatrix(matrix);
        return allList;
    }

    public ArrayList<Integer> printfMatrix(int[][] matrix) {
        ArrayList<Integer> allList = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int startx = 0;
        int starty = 0;
        int endx = m - 1;
        int endy = n - 1;
        while (startx <= endx && starty <= endy) {
            for (int i = starty; i <= endy; i++) {
                allList.add(matrix[startx][i]);
            }
            for (int i = startx + 1; i <= endx; i++) {
                allList.add(matrix[i][endy]);
            }
            if (startx != endx) {
                for (int i = endy - 1; i >= starty; i--) {
                    allList.add(matrix[endx][i]);
                }
            }
            if (starty != endy) {
                for (int i = endx - 1; i > startx; i--) {
                    allList.add(matrix[i][starty]);
                }
            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        return allList;
    }
}
