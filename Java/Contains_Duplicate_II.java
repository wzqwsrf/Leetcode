
//Contains Duplicate II

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日16:54:31
 * @url:https://leetcode.com/problems/contains-duplicate-ii/
 */

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int num = map.get(nums[i]);
                if (i - num <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}