
// 611. Valid Triangle Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 12:05:35
 * @url:https://leetcode.com/problems/valid-triangle-number/description/
 */

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}