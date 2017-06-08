
// 392. Is Subsequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-8 11:58:58
 * @url:https://leetcode.com/problems/is-subsequence/#/description
 */

public class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean flag = false;
        int len1 = s.length();
        int len2 = t.length();
        if (len1 > len2) {
            return flag;
        }
        int k = 0;
        int j = 0;
        while (k < len1 && j < len2) {
            if (s.charAt(k) == t.charAt(j)) {
                k++;
            }
            j++;
        }
        if (k == len1) {
            flag = true;
        }
        return flag;
    }
}