
//Scramble String

import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:19:01
 * @url:https://leetcode.com/problems/merge-sorted-array/
 */

public class Merge_Sorted_Array {

    public void merge(int A[], int m, int B[], int n) {
        int tempArr[] = new int[m];
        System.arraycopy(A, 0, tempArr, 0, m);
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (tempArr[i] > B[j]) {
                A[k] = B[j];
                j++;
            } else {
                A[k] = tempArr[i];
                i++;
            }
            k++;
        }
        while (j < n) {
            A[k] = B[j];
            k++;
            j++;
        }
        while (i < m) {
            A[k] = tempArr[i];
            i++;
            k++;
        }
    }
}