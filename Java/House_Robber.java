
//House Robber  210ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月18日18:01:28
 * @url:https://leetcode.com/problems/house-robber/
 */

public class House_Robber {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int len = num.length;
        if (len == 1) {
            return num[0];
        }
        int dp[] = new int[len];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }
        return dp[len - 1];
    }
}