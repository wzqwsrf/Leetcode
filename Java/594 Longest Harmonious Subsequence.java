
// 594. Longest Harmonious Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 22:46:48
 * @url:https://leetcode.com/problems/longest-harmonious-subsequence/#/description
 */

public class Solution {
    public int findLHS(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (map.containsKey(num + 1)) {
                int currLen = map.get(num + 1) + count;
                res = res > currLen ? res : currLen;
            }
        }
        return res;
    }
}