
// 365. Water and Jug Problem

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-12-19 16:54:46
 * @url:https://leetcode.com/problems/water-and-jug-problem/
 */

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % GCD(x, y) == 0;
    }

    public int GCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}