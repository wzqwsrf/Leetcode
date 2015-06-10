
// Add Binary 444ms

/**
 * 题目：
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月10日15:12:46
 * @url:https://leetcode.com/problems/basic-calculator/
 */

public class Basic_Calculator {
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
        if (num != 0) result += sign * num;
        return result;
    }
}

