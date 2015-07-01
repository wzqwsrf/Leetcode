
// Bitwise AND of Numbers Range

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月18日14:17:49
 * @url:https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */

public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}