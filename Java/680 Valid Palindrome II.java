
// 680. Valid Palindrome II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-20 18:33:05
 * @url:https://leetcode.com/problems/valid-palindrome-ii/description/
 */

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int len = s.length();
        return isPalindrome(s, 0, len - 1, true);
    }

    private boolean isPalindrome(String s, int i, int j, boolean flag) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (flag) {
                    return isPalindrome(s, i + 1, j, false)
                            || isPalindrome(s, i, j - 1, false);
                }
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}