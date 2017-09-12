
// 674. Longest Continuous Increasing Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-12 16:03:16
 * @url:https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int maxLen = 1;
        int currLen = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                currLen++;
            } else {
                maxLen = maxLen > currLen ? maxLen : currLen;
                currLen = 1;
            }
        }
        maxLen = maxLen > currLen ? maxLen : currLen;
        return maxLen;
    }
}