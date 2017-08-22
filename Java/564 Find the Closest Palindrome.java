
// 564. Find the Closest Palindrome

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 16:46:05
 * @url:https://leetcode.com/problems/find-the-closest-palindrome/description/
 */

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        if (len == 1) {
            return String.valueOf(Long.valueOf(n) - 1);
        }
        int mid = (len + 1) / 2;
        String left = n.substring(0, mid);
        long nl = Long.valueOf(n);
        long leftNum = Long.valueOf(left);
        int rightLen = len - mid;
        long diff = Long.MAX_VALUE;
        long result = 0;
        for (int i = -1; i <= 1; i++) {
            long num = getNearestNum(leftNum + i, rightLen);
            if (num == nl) {
                continue;
            }
            long currDiff = Math.abs(num - nl);
            if (currDiff < diff) {
                diff = currDiff;
                result = num;
            }
        }
        return String.valueOf(result);
    }

    private long getNearestNum(long leftNum, int rightLen) {
        String leftStr = String.valueOf(leftNum);
        StringBuilder sb = new StringBuilder(leftStr);
        if (leftNum == 0 || rightLen > leftStr.length()) {
            for (int i = 0; i < rightLen; i++) {
                sb.append("9");
            }
            return Long.valueOf(sb.toString());
        }
        for (int i = 0; i < rightLen; i++) {
            sb.append(leftStr.charAt(rightLen - i - 1));
        }
        return Long.valueOf(sb.toString());
    }
}