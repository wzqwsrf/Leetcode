
// 454. 4Sum II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-10 20:59:59
 * @url:https://leetcode.com/problems/4sum-ii/
 */

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                Integer num = map.get(sum);
                if (num == null) {
                    num = 1;
                } else {
                    num += 1;
                }
                map.put(sum, num);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer num = map.get(-1 * (C[i] + D[j]));
                if (num == null) {
                    num = 0;
                }
                count += num;
            }
        }
        return count;
    }
}