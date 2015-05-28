
//Search in Rotated Sorted Array II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:12:48
 * @url:https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length;
        if (target > A[0]) {
            int i = 1;
            while (i < len && A[i - 1] <= A[i] && target > A[i]) {
                i++;
            }
            if (i >= len) {
                return false;
            }
            if (target == A[i]) {
                return true;
            } else {
                return false;
            }
        } else if (target < A[0]) {
            int i = len - 1;
            while (i > 0 && A[i] >= A[i - 1] && target < A[i]) {
                i--;
            }
            if (i <= 0) {
                return false;
            }
            if (target == A[i]) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}