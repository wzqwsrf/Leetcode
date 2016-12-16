
// 415. Add Strings

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-12-16 20:56:07
 * @url:https://leetcode.com/problems/add-strings/
 */

public class Solution {
    public String addStrings(String num1, String num2) {
        char s1[] = num1.toCharArray();
        char s2[] = num2.toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int len = len1 > len2 ? len1 : len2;
        int s[] = new int[len + 1];
        for (int i = len; i > 0; i--) {
            if (len1 > 0 && len2 > 0) {
                s[i] += s1[--len1] - '0' + s2[--len2] - '0';
            } else if (len1 > 0) {
                s[i] += s1[--len1] - '0';
            } else if (len2 > 0) {
                s[i] += s2[--len2] - '0';
            }
            if (s[i] >= 10) {
                s[i - 1] += 1;
                s[i] -= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len + 1; i++) {
            if (i == 0 && s[i] == 0) {
                continue;
            }
            sb.append(s[i]);
        }
        return sb.toString();
    }
}