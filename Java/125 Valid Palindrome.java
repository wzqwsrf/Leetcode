
// Valid Palindrome

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:15:55
 * @url:https://leetcode.com/problems/valid-palindrome/
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }
        s = s.trim().replaceAll("[' ']+", "").toLowerCase();
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i <= j && i < len && j >= 0) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if (!(start >= 'a' && start <= 'z') && !(start >= '0' && start <= '9')) {
                i++;
                continue;
            }
            if (!(end >= 'a' && end <= 'z') && !(end >= '0' && end <= '9')) {
                j--;
                continue;
            }
            if (start != end) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}