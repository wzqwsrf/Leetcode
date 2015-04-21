
// Longest Valid Parentheses

import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:27:31
 * @url:https://leetcode.com/problems/longest-valid-parentheses/
 */

public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        char array[] = s.toCharArray();
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int flag[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int j = stack.pop();
                    flag[i] = 1;
                    flag[j] = 1;
                }
            }
        }
        int maxLen = 0;
        int tempLen = 0;
        for (int i = 0; i < len; i++) {
            if (flag[i] == 1) {
                tempLen++;
            } else {
                tempLen = 0;
            }
            if (tempLen > maxLen) {
                maxLen = tempLen;
            }
        }
        return maxLen;
    }
}