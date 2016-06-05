
// Integer Break

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-4 20:02:21
 * @url:https://leetcode.com/problems/integer-break/
 */

//解法1
public class Solution {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}

//解法2
public class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[n] = dp[1] * dp[n - 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}