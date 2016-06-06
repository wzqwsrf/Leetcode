
// 338. Counting Bits

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-06 12:46:12
 * @url:https://leetcode.com/problems/counting-bits/
 */

public class Solution {
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        int offset = 1;
        for (int i = 1; i <= num; i++) {
            if (offset << 1 == i) {
                offset = i;
            }
            dp[i] = dp[i - offset] + 1;
        }
        return dp;
    }
}

//思路
public class Solution {
    public int[] countBits(int num) {
        int k = 1;
        int dp[] = new int[num + 1];
        int i = 1;
        while (i <= num) {
            int pos = 0;
            while (i <= num && i >= (int) Math.pow(2, k - 1) && i < (int) Math.pow(2, k)) {
                dp[i] = dp[pos] + 1;
                i++;
                pos++;
            }
            k++;
        }
        return dp;
    }
}