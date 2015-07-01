
// Shortest Palindrome

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月24日10:16:41
 * @url:https://leetcode.com/problems/shortest-palindrome/
 */

public class Solution {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int mid = len / 2;
        String result = null;
        for (int i = mid; i > 0; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                result = getMaxPalindromes(s, i - 1, i);
            }
            if (result != null) {
                break;
            }
            result = getMaxPalindromes(s, i - 1, i - 1);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    private String getMaxPalindromes(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (start >= 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer(s.substring(end));
        sb.reverse();
        return sb.append(s).toString();
    }
}