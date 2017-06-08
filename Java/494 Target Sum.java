
// 494. Target Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-9 04:23:30
 * @url:https://leetcode.com/problems/target-sum/#/description
 */

public class Solution {
    private int count;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        dfs(nums, S, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int S, int pos, int currSum) {
        int len = nums.length;
        if (pos == len && currSum == S) {
            count++;
            return;
        }
        if (pos >= len) {
            return;
        }
        dfs(nums, S, pos + 1, currSum + nums[pos]);
        dfs(nums, S, pos + 1, currSum - nums[pos]);
    }
}