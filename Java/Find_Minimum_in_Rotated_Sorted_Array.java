
//Find Minimum in Rotated Sorted Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:10:56
 * @url:https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] num) {
        int len = num.length - 1;
        int low = 0;
        int high = len;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (num[mid] > num[len]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return num[low];
    }
}