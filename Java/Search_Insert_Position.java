
// Search Insert Position

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:30:56
 * @url:https://leetcode.com/problems/search-insert-position/
 */

public class Search_Insert_Position {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        if (target < A[0]) {
            return 0;
        }
        if (target > A[len - 1]) {
            return len;
        }
        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (A[mid] > target) {
                high = mid - 1;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}