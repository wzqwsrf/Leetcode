
// 357. Count Numbers with Unique Digits

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-14 11:11:41
 * @url:https://leetcode.com/problems/count-numbers-with-unique-digits/
 */

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        n = n > 10 ? 10 : n;
        int f[] = new int[n + 1];
        f[1] = 10;
        f[2] = 9 * 9;
        for (int i = 3; i < n + 1; i++) {
            f[i] = f[i - 1] * (11 - i);
        }
        int dp[] = new int[n + 1];
        dp[1] = 10;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + f[i];
        }
        return dp[n];
    }
}