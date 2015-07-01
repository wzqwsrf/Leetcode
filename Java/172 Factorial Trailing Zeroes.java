
// Factorial Trailing Zeroes

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:36:19
 * @url:https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * 其实就是1到n中5的个数
 * 具体参考：
 */

public class Solution {

    public int trailingZeroes(int n) {
        int num = 0;
        while (n != 0) {
            n /= 5;
            num += n;
        }
        return num;
    }
}
