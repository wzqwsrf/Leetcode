
// Remove Duplicate Letters

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-02-01 18:24:48
 * @url:https://leetcode.com/problems/remove-duplicate-letters/
 */

public class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int array[] = new int[26];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            array[c - 'a']++;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int visited[] = new int[26];
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - 'a';
            array[c]--;
            if (visited[c] == 1) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && array[stack.peek()] != 0) {
                visited[stack.pop()] = 0;
            }
            stack.push(c);
            visited[c] = 1;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            char c = (char) (stack.pop() + 'a');
            sb.append(String.valueOf(c));
        }
        sb = sb.reverse();
        return sb.toString();
    }
}