
// 414. Third Maximum Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-19 15:35:01
 * @url:https://leetcode.com/problems/third-maximum-number/
 */

public class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            if (nums[i] > max2 && nums[i] < max1) {
                max3 = max2;
                max2 = nums[i];
            }
            if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}