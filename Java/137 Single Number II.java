
// Single Number II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:22:21
 * @url:https://leetcode.com/problems/single-number-ii/
 */

public class Solution {

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = 32;
        int count[] = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < A.length; j++) {
                count[i] += (A[j] >> i) & 1;
                count[i] %= 3;
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += count[i] << i;
        }
        return result;
    }
}