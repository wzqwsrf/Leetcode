
// Longest Palindromic Substring

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月02日16:12:19
 * @url:https://leetcode.com/problems/longest-palindromic-substring/
 */

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s.trim())) {
            return "";
        }
        char array[] = s.toCharArray();
        int len = array.length;
        int maxLen = 1;
        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            int len1 = getMaxPalindromes(i, i, len, array);
            if (len1 > maxLen) {
                maxLen = len1;
                l = i - (maxLen - 1) / 2;
                r = i + (maxLen - 1) / 2;
            }
            int len2 = getMaxPalindromes(i, i + 1, len, array);
            if (len2 > maxLen) {
                maxLen = len2;
                l = i - maxLen / 2 + 1;
                r = i + maxLen / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    public int getMaxPalindromes(int l, int r, int len, char array[]) {
        while (l >= 0 && r < len && array[l] == array[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}