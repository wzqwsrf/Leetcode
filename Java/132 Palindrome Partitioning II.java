
// Palindrome Partitioning II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:31:04
 * @url:https://leetcode.com/problems/palindrome-partitioning-ii/
 */

public class Solution {
    public int minCut(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int len = s.length();
        int cutArr[] = new int[len + 1];
        int dp[][] = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            cutArr[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        cutArr[i] = Math.min(cutArr[i], cutArr[j + 1] + 1);
                    }
                }
            }
        }
        return cutArr[0] - 1;
    }
}