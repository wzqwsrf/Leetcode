
// 645. Set Mismatch

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-05 17:24:48
 * @url:https://leetcode.com/problems/set-mismatch/description/
 */

//this solution be quicker
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int count[] = new int[len + 1];
        int sum = 0;
        int num = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                num = nums[i];
            }
        }
        int actualSum = ((1 + len) * len) / 2;
        return new int[]{num, actualSum - (sum - num)};
    }
}

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int res[] = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                res[0] = index + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}