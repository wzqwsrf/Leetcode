
// Longest Increasing Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-27 17:15:04
 * @url:https://leetcode.com/problems/longest-increasing-subsequence/
 */

public class Solution {
    //  解法一
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int dp[] = new int[len + 1];
        dp[0] = nums[0];
        int maxLen = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[maxLen]) {
                dp[++maxLen] = nums[i];
            } else {
                int pos = binarySearch(dp, 0, maxLen, nums[i]);
                dp[pos] = nums[i];
            }
        }
        return maxLen + 1;
    }

    private int binarySearch(int[] dp, int left, int right, int num) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] == num) {
                return mid;
            }
            if (dp[mid] > num) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return left;
    }

    //解法二
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int maxLen = 1;
            int dp[] = new int[len + 1];
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
                        maxLen = dp[i] > maxLen ? dp[i] : maxLen;
                    }
                }
            }
            return maxLen;
        }
    }
}
