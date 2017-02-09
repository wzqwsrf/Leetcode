
// 496. Next Greater Element I

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-2-9 16:25:28
 * @url:https://leetcode.com/problems/next-greater-element-i/
 */

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int len1 = findNums.length;
        int len2 = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(nums[i], stack.peek());
            }
            stack.push(nums[i]);
        }
        int array[] = new int[len1];
        for (int i = 0; i < len1; i++) {
            array[i] = map.getOrDefault(findNums[i], -1);
        }
        return array;
    }
}