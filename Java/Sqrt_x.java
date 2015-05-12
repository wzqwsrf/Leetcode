
// Sqrt(x)  440ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日18:05:09
 * @url:https://leetcode.com/problems/sqrtx/
 */

public class Sqrt_x {

    public int sqrt(int x) {
        double result = x;
        while (Math.abs(result * result - x) > 0.0001) {
            result = (result + x / result) / 2;
        }
        return (int) result;
    }
}