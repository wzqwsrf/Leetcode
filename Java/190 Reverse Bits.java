
// Reverse Bits

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:02:15
 * @url:https://leetcode.com/problems/reverse-bits/
 */

public class Solution {

    public int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i++) {
            m <<= 1;
            m |= (n & 1);
            n >>= 1;
        }
        return m;
    }
}