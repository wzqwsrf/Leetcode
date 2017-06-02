
// 598. Range Addition II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 22:45:21
 * @url:https://leetcode.com/problems/range-addition-ii/#/description
 */

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int len1 = ops.length;
        int a = m;
        int b = n;
        for (int i = 0; i < len1; i++) {
            a = a < ops[i][0] ? a : ops[i][0];
            b = b < ops[i][1] ? b : ops[i][1];
        }
        return a * b;
    }
}