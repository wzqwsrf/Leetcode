
// Remove Duplicates from Sorted Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:19:25
 * @url:https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int start = 0;
        for (int i = 1; i < len; i++) {
            if (A[i] != A[start]) {
                start++;
                A[start] = A[i];
            }
        }
        return start + 1;
    }
}