
// 668. Kth Smallest Number in Multiplication Table

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-8 17:07:53
 * @url:https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
 */

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = getCount(mid, m, n);
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private int getCount(int num, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num / i, n);
        }
        return count;
    }
}