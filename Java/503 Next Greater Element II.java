
// 503. Next Greater Element II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-2-9 16:57:51
 * @url:https://leetcode.com/problems/next-greater-element-ii/
 */

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int array[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            stack.push(i);
        }
        for (int i = len - 1; i >= 0; i--) {
            array[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                array[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        return array;
    }
}