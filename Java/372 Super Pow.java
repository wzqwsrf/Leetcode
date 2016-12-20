
// 372. Super Pow

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-12-20 10:51:15
 * @url:https://leetcode.com/problems/super-pow/
 */

public class Solution {
    public int superPow(int a, int[] b) {
        int MOD = 1337;
        if(b == null || b.length == 0){
            return 1;
        }
        int len = b.length;
        int result = 1;
        for(int i = 0; i < len; i++){
            result = pow(a, b[i], MOD) * pow(result, 10, MOD) % MOD;
        }
        return result;
    }
    public int pow(int x, int n, int MOD){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x % MOD;
        }
        x %= MOD;
        int y = pow(x, n / 2, MOD);
        y = y * y % MOD;
        if(n % 2 == 1){
            y = y * x % MOD;
        }
        return y;
    }
}