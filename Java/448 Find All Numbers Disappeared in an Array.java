
// 448. Find All Numbers Disappeared in an Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-9 12:41:21
 * @url:https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}