
//Maximum Subarray 408ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年08月08日19:00:34
 * @url:https://oj.leetcode.com/problems/maximum-subarray/
 * 最大连续子数组和，非常经典
 * 具体参考http://blog.csdn.net/u013027996/article/details/38423167
 */

public class Maximum_Subarray {
    public int maxSubArray(int[] A) {
        int len = A.length;
        if (len == 1) {
            return A[0];
        }
        int maxSum = A[0];
        int tempSum = 0;
        for (int i = 0; i < len; i++) {
            if (tempSum < 0) {
                tempSum = A[i];
            } else if (tempSum >= 0) {
                tempSum += A[i];
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}
