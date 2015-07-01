
// Longest Common Prefix

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:28:29
 * @url:https://leetcode.com/problems/longest-common-prefix/
 */

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < len; i++) {
            int tempLen = strs[i].length();
            if (minLen > tempLen) {
                minLen = tempLen;
                index = i;
            }
        }
        String shortStr = strs[index];
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (; j < minLen; j++) {
                if (strs[i].charAt(j) != shortStr.charAt(j)) {
                    break;
                }
            }
            if (j < minLen) {
                minLen = j;
            }
        }
        return shortStr.substring(0, minLen);
    }
}

