
// 459. Repeated Substring Pattern

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-06 13:12:57
 * @url:https://leetcode.com/problems/repeated-substring-pattern/description/
 */

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        int len = str.length();
        int mid = len / 2;
        for (int i = mid; i >= 1; i--) {
            if (len % i != 0) {
                continue;
            }
            int size = len / i;
            String repeatStr = str.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                sb.append(repeatStr);
            }
            if (str.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}