
// Ugly Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-19 16:20:08
 * @url:https://leetcode.com/problems/ugly-number/
 */

public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}