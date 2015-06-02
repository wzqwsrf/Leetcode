
//Minimum Size Subarray Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月02日11:09:46
 * @url:https://leetcode.com/problems/minimum-size-subarray-sum/
 */

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = 0;
        int minLen = len + 1;
        int left = 0;
        int right = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                int curLen = right - left + 1;
                minLen = minLen > curLen ? curLen : minLen;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == len + 1 ? 0 : minLen;
    }
}