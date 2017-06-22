
// 402. Remove K Digits

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-22 22:34:05
 * @url:https://leetcode.com/problems/remove-k-digits/#/description
 */

public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        i = 0;
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}