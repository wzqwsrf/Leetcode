
// Kth Largest Element in an Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:15:03
 * @url:https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            int num = 1;
            if (map.containsKey(nums[i])) {
                num += map.get(nums[i]);
            }
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
            map.put(nums[i], num);
        }
        Collections.sort(list);
        int allNum = 0;
        int result = 0;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            int num = list.get(i);
            int tempNum = map.get(num);
            if (allNum < k && tempNum + allNum >= k) {
                result = num;
                break;
            }
            allNum += tempNum;
        }
        return result;
    }
}