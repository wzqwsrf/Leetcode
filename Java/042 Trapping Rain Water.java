
// Trapping Rain Water

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日22:59:18
 * @url:https://leetcode.com/problems/trapping-rain-water/
 */

public class Solution {

    public int trap(int[] A) {
        int len = A.length;
        int max = 0;
        int lArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            lArr[i] = max;
            max = Math.max(max, A[i]);
        }
        max = 0;
        int rArr[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            rArr[i] = max;
            max = Math.max(max, A[i]);
        }
        int mostWater = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(lArr[i], rArr[i]);
            if (min > A[i]) {
                mostWater += min - A[i];
            }
        }
        return mostWater;
    }
}