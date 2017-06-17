
// 167. Two Sum II - Input array is sorted

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-17 13:19:16
 * @url:https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] array = new int[2];
        int low = 0;
        int high = len - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                break;
            }
        }
        return new int[]{low + 1, high + 1};
    }
}