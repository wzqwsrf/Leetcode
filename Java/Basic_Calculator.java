
// Basic Calculator

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月10日15:12:46
 * @url:https://leetcode.com/problems/basic-calculator/
 */

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        int result = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}

