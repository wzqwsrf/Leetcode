
// Remove Duplicates from Sorted Array II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:11:52
 * @url:https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class Solution {

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int len = A.length;
        int twice = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] != A[start]) {
                twice = 1;
                start++;
                A[start] = A[i];
            } else {
                twice++;
                if (twice <= 2) {
                    start++;
                    A[start] = A[i];
                }
            }
        }
        return start + 1;
    }
}