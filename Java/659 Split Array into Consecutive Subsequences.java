
// 659. Split Array into Consecutive Subsequences

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-31 10:51:09
 * @url:https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 * @description:first extend second construct array. ie [1,2,3,4,5] return true;
 */

class Solution {
    public class Solution {
        public boolean isPossible(int[] nums) {
            if (nums == null || nums.length < 3) {
                return false;
            }
            int len = nums.length;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Map<Integer, Integer> conMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < len; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (int i = 0; i < len; i++) {
                if (map.get(nums[i]) == 0) {
                    continue;
                }
                if (conMap.getOrDefault(nums[i], 0) > 0) {
                    conMap.put(nums[i], conMap.get(nums[i]) - 1);
                    conMap.put(nums[i] + 1, conMap.getOrDefault(nums[i] + 1, 0) + 1);
                } else if (map.getOrDefault(nums[i] + 1, 0) > 0
                        && map.getOrDefault(nums[i] + 2, 0) > 0) {
                    conMap.put(nums[i] + 3, conMap.getOrDefault(nums[i] + 3, 0) + 1);
                    map.put(nums[i] + 1, map.get(nums[i] + 1) - 1);
                    map.put(nums[i] + 2, map.get(nums[i] + 2) - 1);
                } else {
                    return false;
                }
                map.put(nums[i], map.get(nums[i]) - 1);
            }
            return true;
        }
    }