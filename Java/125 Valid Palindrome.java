
// 125. Valid Palindrome

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:15:55
 * @url:https://leetcode.com/problems/valid-palindrome/
 * @update:2017-9-20 18:31:20
 */

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }
        s = s.toLowerCase();
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (!isAlphanumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}