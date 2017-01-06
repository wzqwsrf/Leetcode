
// 397. Integer Replacement

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-6 21:14:04
 * @url:https://leetcode.com/problems/integer-replacement/
 */

public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1 && n != -1) {
            if ((n & 1) == 0) {
                n >>= 1;
            } else if (n == 3 || Integer.bitCount(n - 1) < Integer.bitCount(n + 1)) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
}