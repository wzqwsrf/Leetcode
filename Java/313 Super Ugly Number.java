
// Super Ugly Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-12-05 23:13:43
 * @url:https://leetcode.com/problems/super-ugly-number/
 */

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int resArr[] = new int[n];
        resArr[0] = 1;
        int len = primes.length;
        int indexArr[] = new int[len];
        for (int i = 1; i < n; i++) {
            resArr[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                resArr[i] = Math.min(resArr[i],
                        primes[j] * resArr[indexArr[j]]);
            }
            for (int j = 0; j < len; j++) {
                if (resArr[i] == primes[j] * resArr[indexArr[j]]) {
                    indexArr[j]++;
                }
            }
        }
        return resArr[n - 1];
    }
}