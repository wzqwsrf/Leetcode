
// 525. Contiguous Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 18:35:23
 * @url:https://leetcode.com/problems/contiguous-array/#/description
 */

public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int len = nums.length;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            if (zeros == ones) {
                res = Math.max(res, i + 1);
            } else {
                int dif = ones - zeros;
                if (map.containsKey(dif)) {
                    res = Math.max(res, i - map.get(dif));
                } else {
                    map.put(dif, i);
                }
            }
        }
        return res;
    }
}