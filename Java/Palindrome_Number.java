
// Palindrome Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:16:28
 * @url:https://leetcode.com/problems/palindrome-number/
 */

public class Solution {

    public boolean isPalindrome(int x) {
        String str = x + "";
        int len = str.length();
        if (len == 1) {
            return true;
        }
        int i = 0;
        int j = len - 1;
        while (i <= j && i < len && j >= 0) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
