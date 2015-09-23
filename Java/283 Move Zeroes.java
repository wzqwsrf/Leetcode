
// Move Zeroes

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-23 18:34:24
 * @url:https://leetcode.com/problems/move-zeroes/
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while (j < len) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < len) {
            nums[i] = 0;
            i++;
        }
    }
}