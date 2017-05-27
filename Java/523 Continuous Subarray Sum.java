
// 523. Continuous Subarray Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-27 19:32:13
 * @url:https://leetcode.com/problems/continuous-subarray-sum/#/description
 */

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
            if ((k == 0 && dp[i] == 0) || (k != 0 && dp[i] % k == 0)) {
                return true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i != j) {
                    int num = dp[j] - dp[i] + nums[i];
                    if ((k == 0 && num == 0) || (k != 0 && num % k == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}