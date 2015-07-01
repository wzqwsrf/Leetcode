
// Evaluate Reverse Polish Notation

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:13:21
 * @url:https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (isDigit(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int num = 0;
                if (tokens[i].equals("+")) {
                    num = num1 + num2;
                } else if (tokens[i].equals("-")) {
                    num = num1 - num2;
                } else if (tokens[i].equals("*")) {
                    num = num1 * num2;
                } else {
                    num = num1 / num2;
                }
                stack.push(num);
            }
        }
        return stack.peek();
    }

    private boolean isDigit(String token) {
        if (token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/")) {
            return false;
        }
        return true;
    }
}