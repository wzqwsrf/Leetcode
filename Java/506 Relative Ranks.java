
// 506.Relative Ranks

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-16 17:23:25
 * @url:https://leetcode.com/problems/relative-ranks
 */

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String array[] = new String[len];
        for (int i = 0; i < len; i++) {
            int index = map.get(nums[i]);
            if (i == len - 1) {
                array[index] = "Gold Medal";
            } else if (i == len - 2) {
                array[index] = "Silver Medal";
            } else if (i == len - 3) {
                array[index] = "Bronze Medal";
            } else {
                array[index] = String.valueOf(len - i);
            }
        }
        return array;
    }
}