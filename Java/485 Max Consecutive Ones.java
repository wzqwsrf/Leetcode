
// 485. Max Consecutive Ones

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-18 13:39:40
 * @url:https://leetcode.com/problems/max-consecutive-ones/
 */

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;
            } else {
                count = Math.max(count, tempCount);
                tempCount = 0;
            }
        }
        count = Math.max(count, tempCount);
        return count;
    }
}