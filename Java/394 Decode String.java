
// 394. Decode String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-12 02:54:43
 * @url:https://leetcode.com/problems/decode-string/
 */

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
                continue;
            }
            if (s.charAt(i) == ']') {
                if (stack.size() == 1) {
                    int start = stack.pop();
                    int prefix = 0;
                    int count = 1;
                    int k = start - 1;
                    while (k >= 0 && s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                        prefix += (s.charAt(k) - '0') * count;
                        count *= 10;
                        k--;
                    }
                    String inStr = decodeString(s.substring(start + 1, i));
                    k = 0;
                    while (k < prefix) {
                        sb.append(inStr);
                        k++;
                    }

                } else {
                    stack.pop();
                }
                continue;
            }
            if (!stack.isEmpty()) {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}