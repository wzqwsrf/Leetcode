
// 560. Subarray Sum Equals K

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-7 15:11:55
 * @url:https://leetcode.com/problems/subarray-sum-equals-k/#/description
 */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            Integer lnum = map.get(sum - k);
            if (lnum != null) {
                count += lnum;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}