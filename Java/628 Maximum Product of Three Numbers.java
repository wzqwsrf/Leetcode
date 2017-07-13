
// 628. Maximum Product of Three Numbers

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-7-13 19:14:54
 * @url:https://leetcode.com/problems/maximum-product-of-three-numbers/#/description
 */

public class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        int a = max1 * max2 * max3;
        int b = max1 * min1 * min2;
        return a > b ? a : b;
    }
}