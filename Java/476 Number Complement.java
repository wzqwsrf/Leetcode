
// 476. Number Complement

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-12 02:05:30
 * @url:https://leetcode.com/problems/number-complement/
 */

public class Solution {
    public int findComplement(int num) {
        int k = 1;
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                res += k;
            }
            k *= 2;
            num >>= 1;
        }
        return res;
    }
}