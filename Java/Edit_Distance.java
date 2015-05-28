
//Edit Distance

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:02:41
 * @url:https://leetcode.com/problems/edit-distance/
 */

public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i >= 1 && j >= 1) {
                    int cost = 1;
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        cost = 0;
                    }
                    int num1 = dp[i - 1][j - 1] + cost;
                    int num2 = dp[i - 1][j] + 1;
                    int num3 = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(num1, num2), num3);
                } else if (i >= 1) {
                    dp[i][j] = i;
                } else if (j >= 1) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[len1][len2];
    }
}