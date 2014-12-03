
//Spiral Matrix II 348ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月03日109:51:32
 * @url:https://oj.leetcode.com/problems/spiral-matrix-ii/
 * 和Spiral Matrix一样，但是这次不是打印矩阵的内容了，而是赋值，思路仍然一致。
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36638519
 */

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startx = 0;
        int starty = 0;
        int endx = n - 1;
        int endy = n - 1;
        int num = 1;
        while (startx <= endx && starty <= endy) {
            for (int i = starty; i <= endy; i++) {
                matrix[startx][i] = num;
                num++;
            }
            for (int i = startx + 1; i <= endx; i++) {
                matrix[i][endy] = num;
                num++;
            }
            if (startx != endx) {
                for (int i = endy - 1; i >= starty; i--) {
                    matrix[endx][i] = num;
                    num++;
                }
            }
            if (starty != endy) {
                for (int i = endx - 1; i > startx; i--) {
                    matrix[i][starty] = num;
                    num++;
                }
            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        return matrix;
    }
}
