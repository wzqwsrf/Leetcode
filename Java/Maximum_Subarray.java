
//Maximum Subarray 408ms

/**
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */

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
