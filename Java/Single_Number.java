
// Single Number 352ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月17日16:17:44
 * @url:https://oj.leetcode.com/problems/single-number/
 * 整个数组异或，结果就是只出现一次的那个数字
 * 具体参考http://blog.csdn.net/u013027996/article/details/17642559
 */

public class Single_Number {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}

