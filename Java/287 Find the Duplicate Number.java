
// Find the Duplicate Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年10月14日10:34:00
 * @url:https://leetcode.com/problems/find-the-duplicate-number/
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}