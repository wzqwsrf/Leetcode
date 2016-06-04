
// Power of Four

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-4 20:01:23
 * @url:https://leetcode.com/problems/power-of-four/
 */

public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}