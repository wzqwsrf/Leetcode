
// Median of Two Sorted Arrays

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月15日13:32:08
 * @url:https://oj.leetcode.com/problems/add-binary/
 * 中位数经典解法
 */

public class Solution {

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if ((total & 0x1) == 1) {
            return findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
        } else {
            return (findKth(A, 0, m - 1, B, 0, n - 1, total / 2) +
                    findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1)) / 2;
        }
    }

    private double findKth(int[] A, int s1, int e1, int[] B, int s2,
                           int e2, int k) {
        int m = e1 - s1 + 1;
        int n = e2 - s2 + 1;
        if (m > n) {
            return findKth(B, s2, e2, A, s1, e1, k);
        }
        if (s1 > e1) {
            return B[s2 + k - 1];
        }
        if (s2 > e2) {
            return A[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(A[s1], B[s2]);
        }
        int midA = Math.min(k / 2, m);
        int midB = k - midA;
        if (A[s1 + midA - 1] < B[s2 + midB - 1]) {
            return findKth(A, s1 + midA, e1, B, s2, e2, k - midA);
        } else if (A[s1 + midA - 1] > B[s2 + midB - 1]) {
            return findKth(A, s1, e1, B, s2 + midB, e2, k - midB);
        }
        return A[s1 + midA - 1];
    }
}

