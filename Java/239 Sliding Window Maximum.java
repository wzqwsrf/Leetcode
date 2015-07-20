
// Sliding Window Maximum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-20 15:21:47
 * @url:https://leetcode.com/problems/sliding-window-maximum/
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int resArr[] = new int[len - k + 1];
        Queue<Integer> priorityQueue =
                new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        int j = 0;
        for (int i = 1; i < len - k + 1; i++) {
            resArr[j++] = priorityQueue.peek();
            priorityQueue.remove(nums[i - 1]);
            priorityQueue.offer(nums[i + k - 1]);
        }
        resArr[j] = priorityQueue.peek();
        return resArr;
    }
}
