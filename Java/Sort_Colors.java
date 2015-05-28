
//Sort Colors

import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:07:23
 * @url:https://leetcode.com/problems/sort-colors/
 */

public class Sort_Colors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int len = A.length;
        int numArr[] = new int[3];
        for (int i = 0; i < len; i++) {
            numArr[A[i]]++;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numArr[i]; j++) {
                A[k] = i;
                k++;
            }
        }
    }
}