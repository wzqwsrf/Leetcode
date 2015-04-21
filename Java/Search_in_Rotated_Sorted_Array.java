
// Search in Rotated Sorted Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:28:52
 * @url:https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int low = 0;
        int high = len - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > A[low]) {
                if (A[mid] > target && A[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A[mid] < A[low]) {
                if (target > A[mid] && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return -1;
    }
}