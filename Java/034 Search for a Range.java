
// Search for a Range

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:29:47
 * @url:https://leetcode.com/problems/search-for-a-range/
 */

public class Solution {

    public int[] searchRange(int[] A, int target) {
        int len = A.length;
        if (target < A[0] && target > A[len - 1]) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = len - 1;
        int mid = 0;
        boolean flag = false;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (A[mid] > target) {
                high = mid - 1;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                flag = true;
                break;
            }
        }
        int array[] = new int[2];
        array[0] = -1;
        array[1] = -1;
        if (flag) {
            int tempMid = mid;
            while (tempMid + 1 < len && A[tempMid + 1] == target) {
                tempMid++;
            }
            array[1] = tempMid;
            tempMid = mid;
            while (tempMid - 1 >= 0 && A[tempMid - 1] == target) {
                tempMid--;
            }
            array[0] = tempMid;
        }
        return array;
    }
}