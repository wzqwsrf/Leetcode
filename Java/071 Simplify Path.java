
// Simplify Path

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:01:29
 * @url:https://leetcode.com/problems/simplify-path/
 */

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int len = path.length();
        char array[] = path.toCharArray();
        int i = 0;
        while (i < len) {
            if (array[i] == '/') {
                StringBuilder sb = new StringBuilder();
                int j = i + 1;
                while (j < len && array[j] != '/') {
                    sb.append(String.valueOf(array[j]));
                    j++;
                }
                i = j - 1;
                String tempStr = sb.toString();
                if (tempStr.length() == 0) {
                    i++;
                    continue;
                }
                if (tempStr.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!tempStr.equals(".")) {
                    stack.push(tempStr);
                }
            }
            i++;
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String finalPath = "";
        while (!stack.isEmpty()) {
            finalPath = "/" + stack.peek() + finalPath;
            stack.pop();
        }
        return finalPath;
    }
}