
// H-Index II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-06 14:58:57
 * @url:https://leetcode.com/problems/h-index-ii/
 * 这个计算方式不太理解
 */

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] == (len - mid)) {
                return citations[mid];
            } else if (citations[mid] > (len - mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}