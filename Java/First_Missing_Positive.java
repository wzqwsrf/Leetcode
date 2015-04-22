
// First Missing Positive

import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日22:57:57
 * @url:https://leetcode.com/problems/first-missing-positive/
 */

public class First_Missing_Positive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] <= 0) {
                A[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(A);
        if (A[0] != 1) {
            return 1;
        }
        int k = 2;
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) {
                continue;
            }
            if (A[i] != k) {
                return k;
            }
            k++;
        }
        return k;
    }
}