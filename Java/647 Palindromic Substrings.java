
// 647. Palindromic Substrings

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-05 18:58:47
 * @url:https://leetcode.com/problems/palindromic-substrings/description/
 */

public class Solution {
    private int count;

    public int countSubstrings(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        count = 0;
        char array[] = s.toCharArray();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            isPalindromic(array, len, i, i);
            isPalindromic(array, len, i, i + 1);
        }
        return count;
    }

    public void isPalindromic(char array[], int len, int l, int r) {
        while (l >= 0 && r < len && array[l] == array[r]) {
            l--;
            r++;
            count++;
        }
    }
}