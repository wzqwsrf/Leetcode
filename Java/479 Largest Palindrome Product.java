
// 479. Largest Palindrome Product

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-21 22:08:47
 * @url:https://leetcode.com/problems/largest-palindrome-product/description/
 */

class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int high = (int) Math.pow(10, n);
        int low = high / 10;
        for (int i = high - 1; i > low; i--) {
            long num = Long.valueOf(i +
                    new StringBuilder(String.valueOf(i)).reverse().toString());
            for (long j = high - 1; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;
    }
}