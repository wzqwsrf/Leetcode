
// Contains Duplicate 444ms

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://leetcode.com/problems/contains-duplicate/
 * hashmap 统计数字出现的次数，如果大于1就返回true。
 */

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null && nums.length == 0) {
            return false;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
