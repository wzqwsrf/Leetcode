
// Valid Parentheses

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:07:43
 * @url:https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || "".equals(s.trim())) {
            return false;
        }
        char array[] = s.toCharArray();
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                stack.push(array[i]);
            } else if (array[i] == ')' || array[i] == '}' || array[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.peek();
                stack.pop();
                if (array[i] == ')') {
                    if (c != '(') {
                        return false;
                    }
                }
                if (array[i] == '}') {
                    if (c != '{') {
                        return false;
                    }
                }
                if (array[i] == ']') {
                    if (c != '[') {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}