
// Maximum Product Subarray

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年10月17日11:39:35
 * @url:https://oj.leetcode.com/problems/maximum-product-subarray/
 * 最大连续字数组乘积。
 * 具体参考http://blog.csdn.net/u013027996/article/details/40183455
 */

public class Solution {

    public int maxProduct(int[] A) {
        int len = A.length;
        int max = A[0];
        int min = A[0];
        int temp1 = 0;
        int temp2 = 0;
        int result = A[0];
        for (int i = 1; i < len; i++) {
            temp1 = min * A[i];
            temp2 = max * A[i];
            min = Math.min(Math.min(temp1, temp2), A[i]);
            max = Math.max(Math.max(temp1, temp2), A[i]);
            result = max > result ? max : result;
        }
        return result;
    }
}
