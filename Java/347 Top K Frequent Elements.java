
// Top K Frequent Elements

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-5 21:53:08
 * @url:https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int num = 1;
            if (map.containsKey(nums[i])) {
                num += map.get(nums[i]);
            }
            map.put(nums[i], num);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(), new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
        queue.addAll(map.entrySet());
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resList.add(queue.poll().getKey());
        }
        return resList;
    }
}