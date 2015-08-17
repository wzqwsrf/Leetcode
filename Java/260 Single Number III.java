
// Single Number III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-17 16:19:31
 * @url:https://leetcode.com/problems/single-number-iii/
 */

public class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        int num = 0;
        while ((result & 1) == 0 && num < 32) {
            result >>= 1;
            num++;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++) {
            if (((nums[i] >> num) & 1) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        int array[] = new int[2];
        array[0] = num1;
        array[1] = num2;
        return array;
    }
}