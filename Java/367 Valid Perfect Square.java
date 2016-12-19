
// 367. Valid Perfect Square

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-12-19 16:17:06
 * @url:https://leetcode.com/problems/valid-perfect-square/
 */

public class Solution {
    public boolean isPerfectSquare(int num) {
        int k = 1;
        while (num > 0) {
            num -= k;
            k += 2;
        }
        return num == 0;
    }
}