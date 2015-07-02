
// Find Peak Element

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:17:06
 * @url:https://leetcode.com/problems/find-peak-element/
 */

public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}