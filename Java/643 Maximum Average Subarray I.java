
// 643. Maximum Average Subarray I

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-05 16:57:14
 * @url:https://leetcode.com/problems/maximum-average-subarray-i/description/
 */

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 0, j = k; j < len; i++, j++) {
            sum = sum + nums[j] - nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return (double) max / k;
    }
}