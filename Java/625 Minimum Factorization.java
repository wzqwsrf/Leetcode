
// 625. Minimum Factorization

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-19 15:24:25
 * @url:https://leetcode.com/problems/minimum-factorization/#/description
 */

public class Solution {
    public int smallestFactorization(int a) {
        if (a < 10) {
            return a;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                list.add(i);
                a /= i;
            }
        }
        if (a != 1) {
            return 0;
        }
        int size = list.size();
        long num = 0;
        int k = 1;
        for (int i = 0; i < size; i++) {
            num += (long) list.get(i) * (long) k;
            k *= 10;
            if (num > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) num;
    }
}