
// Minimum Window Substring

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:07:50
 * @url:https://leetcode.com/problems/minimum-window-substring/
 */

public class Solution {

    public String minWindow(String S, String T) {
        if (S == null || T == null || "".equals(S) || "".equals(T)) {
            return "";
        }
        int size = 123;
        int inArr[] = new int[size];
        int numArr[] = new int[size];
        int len1 = S.length();
        int len2 = T.length();
        for (int i = 0; i < len2; i++) {
            inArr[T.charAt(i)]++;
        }
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        String minS = "";
        for (int end = 0; end < len1; end++) {
            int num1 = S.charAt(end);
            if (inArr[num1] != 0) {
                numArr[num1]++;
                if (numArr[num1] <= inArr[num1]) {
                    count++;
                }
                if (count == len2) {
                    while (inArr[S.charAt(start)] == 0
                            || numArr[S.charAt(start)] > inArr[S.charAt(start)]) {
                        if (numArr[S.charAt(start)] > inArr[S.charAt(start)]) {
                            numArr[S.charAt(start)]--;
                        }
                        start++;
                    }
                    int tempLen = end - start + 1;
                    if (minLen > tempLen) {
                        minLen = tempLen;
                        minS = S.substring(start, end + 1);
                    }
                }
            }
        }
        return minS;
    }
}