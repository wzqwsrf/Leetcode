
//Count Primes

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月02日11:11:42
 * @url:https://leetcode.com/problems/count-primes/
 */

public class Count_Primes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}