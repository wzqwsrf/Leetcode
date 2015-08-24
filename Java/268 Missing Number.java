
// Missing Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-24 10:08:23
 * @url:https://leetcode.com/problems/missing-number/
 */

//解法一
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        return (n * (n + 1)) / 2 - sum;
    }
}

//解法二
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int missNum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}

