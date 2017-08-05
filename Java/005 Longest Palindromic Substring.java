
// Longest Palindromic Substring

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月02日16:12:19
 * @update:2017-08-05 19:13:49
 * @url:https://leetcode.com/problems/longest-palindromic-substring/
 */

public class Solution {
    private int maxLen;
    private int start;

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s.trim())) {
            return "";
        }
        start = 0;
        maxLen = 1;
        char array[] = s.toCharArray();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            getMaxPalindromes(array, len, i, i);
            getMaxPalindromes(array, len, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    public void getMaxPalindromes(char array[], int len, int l, int r) {
        while (l >= 0 && r < len && array[l] == array[r]) {
            l--;
            r++;
        }
        int tempLen = r - l - 1;
        if (tempLen > maxLen) {
            maxLen = tempLen;
            start = l + 1;
        }
    }
}