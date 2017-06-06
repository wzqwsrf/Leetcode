
// 532. K-diff Pairs in an Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:42:54
 * @url:https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
 */

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer tempNum = map.get(entry.getKey() + k);
            if (k == 0) {
                count = tempNum != null && tempNum >= 2 ? count + 1 : count;
            } else {
                count = tempNum != null ? count + 1 : count;
            }
        }
        return count;
    }
}