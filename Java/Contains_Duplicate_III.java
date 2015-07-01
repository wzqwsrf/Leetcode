
// Contains Duplicate III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月18日14:41:48
 * @url:https://leetcode.com/problems/contains-duplicate-iii/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (k < 1 || t < 0) {
            return false;
        }
        int len = nums.length;
        SortedSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < len; i++) {
            long left = (long) nums[i] - t;
            long right = (long) nums[i] + t + 1;
            SortedSet<Long> subSet = set.subSet(left, right);
            if (!subSet.isEmpty()) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}