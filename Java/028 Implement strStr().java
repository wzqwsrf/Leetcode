
// Implement strStr()

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:20:53
 * @url:https://leetcode.com/problems/implement-strstr/
 */

public class Solution {

    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; i < (len1 - len2 + 1); i++) {
            String tempStr = haystack.substring(i, i + len2);
            if (tempStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}