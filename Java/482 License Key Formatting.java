
// 482. License Key Formatting

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-12 00:59:26
 * @url:https://leetcode.com/problems/license-key-formatting/
 */

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        char array[] = S.toCharArray();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (array[i] == '-') {
                continue;
            }
            if (count == K) {
                sb.append('-');
                count = 0;
            }
            if (array[i] >= 'a' && array[i] <= 'z') {
                sb.append((char) (array[i] - 'a' + 'A'));
            } else {
                sb.append(array[i]);
            }
            count++;
        }
        return sb.reverse().toString();
    }
}