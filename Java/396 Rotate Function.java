
// 396. Rotate Function

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-24 12:08:09
 * @url:https://leetcode.com/problems/rotate-function/description/
 */

class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int sum = 0;
        int fsum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            fsum += i * A[i];
        }
        int maxSum = fsum;
        for (int i = 0; i < len - 1; i++) {
            fsum = fsum - sum + len * A[i];
            maxSum = Math.max(maxSum, fsum);
        }
        return maxSum;
    }
}