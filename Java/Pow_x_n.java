
// Pow(x, n)

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日23:04:31
 * @url:https://leetcode.com/problems/powx-n/
 */

public class Solution {

    public double actualPow(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else {
            double result = actualPow(x, n / 2);
            if (n % 2 == 1) {
                return result * result * x;
            } else {
                return result * result;
            }
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n > 0) {
            return actualPow(x, n);
        } else {
            return 1.0 / actualPow(x, -n);
        }
    }
}