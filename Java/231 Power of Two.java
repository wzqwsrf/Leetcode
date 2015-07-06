
// Power of Two

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-06 11:29:18
 * @url:https://leetcode.com/problems/power-of-two/
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}