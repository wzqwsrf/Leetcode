
// 678. Valid Parenthesis String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-20 18:34:55
 * @url:https://leetcode.com/problems/valid-parenthesis-string/description/
 */

class Solution {
    public boolean checkValidString(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int len = s.length();
        int visited[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack1.push(i);
                continue;
            }
            if (s.charAt(i) == ')') {
                if (!stack1.isEmpty()) {
                    int j = stack1.pop();
                    visited[j] = 1;
                    visited[i] = 1;
                } else {
                    stack2.push(i);
                }
            }
        }
        int i = len - 1;
        while (!stack1.isEmpty() && i >= 0) {
            if (visited[i] == 0 && s.charAt(i) == '*' && i > stack1.peek()) {
                stack1.pop();
                visited[i] = 1;
            }
            i--;
        }
        i = len - 1;
        while (!stack2.isEmpty() && i >= 0) {
            if (visited[i] == 0 && s.charAt(i) == '*' && i < stack2.peek()) {
                stack2.pop();
                visited[i] = 1;
            }
            i--;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}