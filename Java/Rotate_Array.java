
// Rotate Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:02:10
 * @url:https://leetcode.com/problems/rotate-array/
 */

public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k %= n;
        }
        int newNums[] = new int[n];
        for (int i = 0; i < k; i++) {
            newNums[i] = nums[n - k + i];
        }
        for (int i = k; i < n; i++) {
            newNums[i] = nums[i - k];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }
    }
}