
// 507. Perfect Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-16 17:39:36
 * @url:https://leetcode.com/problems/perfect-number/
 */

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int result = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result += i;
                if (i != num / i) {
                    result += num / i;
                }
            }
        }
        result += 1;
        return result == num;
    }
}