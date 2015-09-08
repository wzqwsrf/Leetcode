
// First Bad Version

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-08 14:30:48
 * @url:https://leetcode.com/problems/first-bad-version/
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            boolean badVersion1 = isBadVersion(mid);
            boolean badVersion2 = isBadVersion(mid - 1);
            if (badVersion1 && !badVersion2) {
                return mid;
            }
            if (!badVersion1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}