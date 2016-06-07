
// 334. Increasing Triplet Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-07 15:04:15
 * @url:https://leetcode.com/problems/increasing-triplet-subsequence/
 */

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= c1) {
                c1 = nums[i];
            } else if (nums[i] <= c2) {
                c2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}