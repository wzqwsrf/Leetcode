
//Decode Ways

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:22:43
 * @url:https://leetcode.com/problems/decode-ways/
 */

public class Decode_Ways {

    public int numDecodings(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int len = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int dp[] = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i >= 2 && (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2') && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}