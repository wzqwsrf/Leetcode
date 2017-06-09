
// 413. Arithmetic Slices

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-9 13:19:37
 * @url:https://leetcode.com/problems/arithmetic-slices/#/description
 */

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        int count = 0;
        int dp[] = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            count += dp[i];
        }
        return count;
    }
}